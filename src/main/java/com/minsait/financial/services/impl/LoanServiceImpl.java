package com.minsait.financial.services.impl;

import com.minsait.financial.exceptions.CustomerDoesNotHaveALoanException;
import com.minsait.financial.exceptions.LoanNotFoundException;
import com.minsait.financial.exceptions.LoanRequestDeniedException;
import com.minsait.financial.models.CustomerModel;
import com.minsait.financial.models.LoanModel;
import com.minsait.financial.models.dtos.requests.loan.LoanRequestDto;
import com.minsait.financial.models.dtos.responses.loan.LoanResponseDto;
import com.minsait.financial.repositories.CustomerRepository;
import com.minsait.financial.repositories.LoanRepository;
import com.minsait.financial.services.LoanService;
import com.minsait.financial.strategies.loans.BronzeRelationshipLoan;
import com.minsait.financial.strategies.loans.GoldRelationshipLoan;
import com.minsait.financial.strategies.loans.LoanStrategy;
import com.minsait.financial.strategies.loans.SilverRelationshipLoan;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;
    private final CustomerServiceImpl customerService;
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Override
    public LoanResponseDto createLoan(String documentNumber, LoanRequestDto loanRequestDto) {
        CustomerModel customerModel = modelMapper.map(customerService.GetByDocumentNumber(documentNumber), CustomerModel.class);
        var loan = modelMapper.map(loanRequestDto, LoanModel.class);
        loan.setCustomerModel(customerModel);
        loan.setCustomerDocumentNumber(documentNumber);
        if (canGetNewLoan(customerModel, loan)){
            BigDecimal loanFinalValue = calculateFinalValue(loan);
            loan.setFinalValue(loanFinalValue);
            loanRepository.save(loan);
            return modelMapper.map(loan, LoanResponseDto.class);
        }
        throw new LoanRequestDeniedException("Empréstimo indisponível. Limite excedido.");

    }

    @Override
    public LoanResponseDto getLoan(String documentNumber, Long id) {
        customerService.GetByDocumentNumber(documentNumber);
        return modelMapper.map(loanRepository.findById(id)
                .orElseThrow(() -> new LoanNotFoundException("Empréstimo não encontrado.")), LoanResponseDto.class);
    }

    @Override
    public void delete(String documentNumber, Long id) {
        getLoan(documentNumber, id);
        loanRepository.deleteById(id);
    }

    @Override
    public List<LoanResponseDto> getAllLoans(String documentNumber) {
        CustomerModel customerModel = modelMapper.map(customerService.GetByDocumentNumber(documentNumber), CustomerModel.class);
        if (customerModel.getLoans().isEmpty()){
            throw new CustomerDoesNotHaveALoanException("O cliente informado não possui empréstimos.");
        }
       return customerModel.getLoans().stream().map(loan ->modelMapper.map(loan, LoanResponseDto.class)).toList();
    }


    private BigDecimal calculateFinalValue (LoanModel loan){
        LoanStrategy loanStrategy;
        switch (loan.getRelationship()){
            case BRONZE -> loanStrategy = new BronzeRelationshipLoan();

            case SILVER -> loanStrategy = new SilverRelationshipLoan();

            case GOLD -> loanStrategy = new GoldRelationshipLoan();

            default -> throw new IllegalStateException("Unexpected value: " + loan.getRelationship());
        }
        return loanStrategy.calculateFinalValue(loan);
    }

    private Boolean canGetNewLoan(CustomerModel customer, LoanModel loan){
        BigDecimal total = new BigDecimal(0);
        for (LoanModel l : customer.getLoans()) {
            total = total.add(l.getInitialValue());
        }
        if (total.add(loan.getInitialValue()).compareTo(customer.getMonthlyIncome().multiply(new BigDecimal(10)))  == 1){
            return false;
        }
        return true;
    }


}
