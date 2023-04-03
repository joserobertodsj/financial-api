package com.minsait.financial.services;

import com.minsait.financial.models.dtos.requests.CustomerRequestDto;
import com.minsait.financial.models.dtos.responses.CustomerResponseDto;

import java.util.List;

public interface CustomerService {
    CustomerResponseDto createCustomer(CustomerRequestDto customerRequestDto);
    List<CustomerResponseDto> getAllCustomers();
    CustomerResponseDto getCustomerByDocumentNumber(String documentoNumber);
    void deleteCustomerByDocumentNumber(String documentNumber);
    CustomerResponseDto updateCustomer(String documentNumber, CustomerRequestDto customerRequestDto);


}
