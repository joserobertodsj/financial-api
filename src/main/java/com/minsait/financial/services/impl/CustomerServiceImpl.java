package com.minsait.financial.services.impl;

import com.minsait.financial.models.CustomerModel;
import com.minsait.financial.models.dtos.requests.customer.CustomerRequestDto;
import com.minsait.financial.models.dtos.requests.customer.CustomerRequestUpdateDto;
import com.minsait.financial.models.dtos.responses.address.AddressResponseDto;
import com.minsait.financial.models.dtos.responses.customer.CustomerResponseDto;
import com.minsait.financial.repositories.CustomerRepository;
import com.minsait.financial.services.CustomerService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public CustomerResponseDto getCustomerByDocumentNumber(String documentoNumber) {
        return null;
    }

    @Override
    public void deleteCustomerByDocumentNumber(String documentNumber) {

    }

    @Override
    public CustomerResponseDto updateCustomer(String documentNumber, CustomerRequestUpdateDto customerRequestUpdateDto) {
        return null;
    }

    @Override
    public AddressResponseDto getAddress(Long idCustomer) {
        return null;
    }
}
