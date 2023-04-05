package com.minsait.financial.services;

import com.minsait.financial.models.dtos.requests.customer.CustomerRequestDto;
import com.minsait.financial.models.dtos.requests.customer.CustomerRequestUpdateDto;
import com.minsait.financial.models.dtos.responses.customer.CustomerResponseDto;

import java.util.List;

public interface CustomerService {
    CustomerResponseDto createCustomer(CustomerRequestDto customerRequestDto);
    List<CustomerResponseDto> getAllCustomers();
    CustomerResponseDto GetByDocumentNumber(String documentNumber);
    void deleteByDocumentNumber(String documentNumber);
    CustomerResponseDto updateCustomer(String documentNumber, CustomerRequestUpdateDto customerRequestUpdateDto);


}
