package com.minsait.financial.services;

import com.minsait.financial.models.dtos.requests.loan.LoanRequestDto;
import com.minsait.financial.models.dtos.responses.loan.LoanResponseDto;

import java.util.List;

public interface LoanService {
    LoanResponseDto createLoan (String documentNumber, LoanRequestDto loanRequestDto);
    LoanResponseDto getLoan(String documentNumber, Long id);
    void delete(String documentNumber, Long id);

    List<LoanResponseDto> getAllLoans(String documentNumber);
}
