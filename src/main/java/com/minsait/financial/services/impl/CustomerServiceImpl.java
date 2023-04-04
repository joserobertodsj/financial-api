package com.minsait.financial.services.impl;

import com.minsait.financial.exceptions.CustomerNotFound;
import com.minsait.financial.models.CustomerModel;
import com.minsait.financial.models.dtos.requests.CustomerRequestDto;
import com.minsait.financial.models.dtos.responses.CustomerResponseDto;
import com.minsait.financial.repositories.CustomerRepository;
import com.minsait.financial.services.CustomerService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
            throw new CustomerNotFound("Cliente não encontrado!");
        }

        return modelMapper.map(customerModel, CustomerResponseDto.class);
    }

    @Override
    public void deleteByDocumentNumber(String documentNumber) {
        Optional<CustomerModel> customerModel = customerRepository.findByDocumentNumber(documentNumber);
        if (!customerModel.isPresent()){
            throw new CustomerNotFound("Cliente não encontrado!");
        }
        customerRepository.delete(customerModel.get());

    }

    @Override
    public CustomerResponseDto updateCustomer(String documentNumber, CustomerRequestDto customerRequestDto) {
        return null;
    }
}
