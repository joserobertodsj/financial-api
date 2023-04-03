package com.minsait.financial.controllers;

import com.minsait.financial.models.dtos.requests.customer.CustomerRequestDto;
import com.minsait.financial.models.dtos.responses.customer.CustomerResponseDto;
import com.minsait.financial.services.impl.CustomerServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerServiceImpl customerService;
    private final ModelMapper modelMapper;


    @PostMapping
    public ResponseEntity<CustomerResponseDto> createCustomer(@RequestBody @Valid CustomerRequestDto customerRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(customerRequestDto));
    }

}
