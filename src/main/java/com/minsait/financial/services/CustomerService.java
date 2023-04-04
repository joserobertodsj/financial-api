package com.minsait.financial.services;

import com.minsait.financial.models.dtos.requests.CustomerRequestDto;
import com.minsait.financial.models.dtos.requests.CustomerRequestUpdateDto;
import com.minsait.financial.models.dtos.responses.CustomerResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    CustomerResponseDto createCustomer(CustomerRequestDto customerRequestDto);
    List<CustomerResponseDto> getAllCustomers();
    CustomerResponseDto GetByDocumentNumber(String documentNumber);
    void deleteByDocumentNumber(String documentNumber);
    CustomerResponseDto updateCustomer(String documentNumber, CustomerRequestUpdateDto customerRequestUpdateDto);


}
