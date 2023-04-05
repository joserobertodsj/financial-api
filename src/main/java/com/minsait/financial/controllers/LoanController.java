package com.minsait.financial.controllers;

import com.minsait.financial.models.dtos.requests.loan.LoanRequestDto;
import com.minsait.financial.models.dtos.responses.loan.LoanResponseDto;
import com.minsait.financial.services.impl.LoanServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
@AllArgsConstructor
public class LoanController {

    private final LoanServiceImpl loanService;


    @PostMapping("/{documentNumber}/loans")
    public ResponseEntity<LoanResponseDto> createLoan(@PathVariable String documentNumber, @RequestBody @Valid LoanRequestDto loanRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(loanService.createLoan(documentNumber, loanRequestDto));
    }

    @GetMapping("/{documentNumber}/loans/{id}")
    public ResponseEntity<LoanResponseDto> getLoanById(@PathVariable String documentNumber, @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(loanService.getLoanById(documentNumber, id));
    }

}
