package com.minsait.financial.controllers;

import com.minsait.financial.models.dtos.requests.customer.CustomerRequestDto;
import com.minsait.financial.models.dtos.requests.customer.CustomerRequestUpdateDto;
import com.minsait.financial.models.dtos.responses.customer.CustomerResponseDto;
import com.minsait.financial.services.impl.CustomerServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerServiceImpl customerService;


    @PostMapping
    public ResponseEntity<CustomerResponseDto> createCustomer(@RequestBody @Valid CustomerRequestDto customerRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(customerRequestDto));
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponseDto>> getAllCustomers(){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.getAllCustomers());
    }

    @GetMapping("/{documentNumber}")
    public ResponseEntity<CustomerResponseDto> getCustomerByDocumentNumber(@PathVariable @Valid String documentNumber){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.GetByDocumentNumber(documentNumber));
    }

    @DeleteMapping("/{documentNumber}")
    public ResponseEntity<Void> deleteCustomerByDocumentNumber(@PathVariable String documentNumber){
        customerService.deleteByDocumentNumber(documentNumber);
         return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @PutMapping("/{documentNumber}")
    public ResponseEntity<CustomerResponseDto> updateCustomer(@PathVariable String documentNumber
            , @RequestBody CustomerRequestUpdateDto customerRequestUpdateDto){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.updateCustomer(documentNumber, customerRequestUpdateDto));
    }
}
