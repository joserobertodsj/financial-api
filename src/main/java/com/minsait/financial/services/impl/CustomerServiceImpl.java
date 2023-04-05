package com.minsait.financial.services.impl;

import com.minsait.financial.exceptions.CustomerNotFoundException;
import com.minsait.financial.models.CustomerModel;
import com.minsait.financial.models.dtos.requests.customer.CustomerRequestDto;
import com.minsait.financial.models.dtos.requests.customer.CustomerRequestUpdateDto;
import com.minsait.financial.models.dtos.responses.customer.CustomerResponseDto;
import com.minsait.financial.repositories.CustomerRepository;
import com.minsait.financial.services.CustomerService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    //injeção via construtor
    private final ModelMapper modelMapper;
    private final CustomerRepository customerRepository;



    @Override
    public CustomerResponseDto createCustomer(CustomerRequestDto customerRequestDto) {
        CustomerModel customerModel = customerRepository.save(modelMapper.map(customerRequestDto, CustomerModel.class));
        return modelMapper.map(customerModel, CustomerResponseDto.class);

    }

    @Override
    public List<CustomerResponseDto> getAllCustomers() {
        return customerRepository.findAll().stream().map(customer -> modelMapper.map(customer, CustomerResponseDto.class)).toList();
    }

    @Override
    public CustomerResponseDto GetByDocumentNumber(String documentNumber) {

        Optional<CustomerModel> customerModel = customerRepository.findByDocumentNumber(documentNumber);
        if (!customerModel.isPresent()){
            throw new CustomerNotFoundException("Cliente não encontrado!");
        }
        return modelMapper.map(customerModel, CustomerResponseDto.class);
    }

    @Transactional
    @Override
    public void deleteByDocumentNumber(String documentNumber) {
        CustomerModel customerModel = modelMapper.map(GetByDocumentNumber(documentNumber), CustomerModel.class);
        customerRepository.deleteByDocumentNumber(customerModel.getDocumentNumber());
    }

    @Override
    public CustomerResponseDto updateCustomer(String documentNumber, CustomerRequestUpdateDto customerRequestUpdateDto) {
        CustomerModel customerModel = modelMapper.map(GetByDocumentNumber(documentNumber), CustomerModel.class);
        updateAttributes(customerRequestUpdateDto, customerModel);
        customerRepository.save(customerModel);
        return modelMapper.map(customerModel, CustomerResponseDto.class);
    }




//______________________________________________________________________________________________________________________
    public void updateAttributes(CustomerRequestUpdateDto customerRequestUpdateDto, CustomerModel customerModel){
        if (customerRequestUpdateDto.getName() != null) customerModel.setName(customerRequestUpdateDto.getName());
        if (customerRequestUpdateDto.getPhoneNumber() != null) customerModel.setPhoneNumber(customerRequestUpdateDto.getPhoneNumber());
        if (customerRequestUpdateDto.getMonthlyIncome() != null) customerModel.setMonthlyIncome(customerRequestUpdateDto.getMonthlyIncome());
        if (customerRequestUpdateDto.getAddress() != null) customerModel.setAddress(customerRequestUpdateDto.getAddress());
    }
}
