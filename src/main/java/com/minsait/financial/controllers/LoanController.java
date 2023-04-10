package com.minsait.financial.controllers;

import com.minsait.financial.models.dtos.requests.loan.LoanRequestDto;
import com.minsait.financial.models.dtos.responses.loan.LoanResponseDto;
import com.minsait.financial.services.impl.LoanServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return ResponseEntity.status(HttpStatus.OK).body(loanService.getLoan(documentNumber, id));
    }

    @GetMapping("/{documentNumber}/loans")
    public ResponseEntity<List<LoanResponseDto>> getAllLoans(@PathVariable String documentNumber){
        return ResponseEntity.status(HttpStatus.OK).body(loanService.getAllLoans(documentNumber));
    }

    @DeleteMapping("/{documentNumber}/loans/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLoan(@PathVariable String documentNumber, @PathVariable Long id){
        loanService.delete(documentNumber, id);
    }



}
