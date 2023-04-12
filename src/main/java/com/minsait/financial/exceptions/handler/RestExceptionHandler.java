package com.minsait.financial.exceptions.handler;

import com.minsait.financial.exceptions.*;
import com.minsait.financial.exceptions.details.*;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class RestExceptionHandler{
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<?> handleDocumentNumberNotFoundException(CustomerNotFoundException e){
        CustomerNotFoundDetails customerNotFoundDetails = CustomerNotFoundDetails
                .CustomerNotFoundDetailsBuilder
                .newBuilder()
                .withTitulo("CustomerNotFoundException")
                .withStatus(HttpStatus.NOT_FOUND.value())
                .withMensagem(e.getMessage())
                .withTimestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(customerNotFoundDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(LoanNotFoundException.class)
    public ResponseEntity<?> handleLoanNotFoundException(LoanNotFoundException e){
        LoanNotFoundDetails loanNotFoundDetails = LoanNotFoundDetails.LoanNotFoundDetailsBuilder
                .newBuilder()
                .withTitulo("LoanNotFoundException")
                .withStatus(HttpStatus.NOT_FOUND.value())
                .withMensagem(e.getMessage())
                .withTimestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(loanNotFoundDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, Object> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object>handleDataIntegrityViolationException(DataIntegrityViolationException e){
        String message = "CPF já cadastrado no sistema.";
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(GoldRelationshipLoanNotAllowedException.class)
    public ResponseEntity<?> handleGoldRelationshipLoanNotAllowedException(GoldRelationshipLoanNotAllowedException e){
        GoldRelationshipLoanNotAllowedDetails goldRelationshipLoanNotAllowedDetails = GoldRelationshipLoanNotAllowedDetails
                .GoldRelationshipLoanNotAllowedDetailsBuilder
                .newBuilder()
                .withTitle("GoldRelationshipLoanNotAllowedException")
                .withStatus(HttpStatus.FORBIDDEN.value())
                .withMessage(e.getMessage())
                .withTimestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(goldRelationshipLoanNotAllowedDetails, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(LoanRequestDeniedException.class)
    public ResponseEntity<?> handleLoanRequestDeniedException(LoanRequestDeniedException e) {
        LoanRequestDeniedDetails loanRequestDeniedDetails = LoanRequestDeniedDetails
                .LoanRequestDeniedDetailsBuilder
                .newBuilder()
                .withTitle("LoanRequestDeniedException")
                .withStatus(HttpStatus.FORBIDDEN.value())
                .withMessage(e.getMessage())
                .withTimestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(loanRequestDeniedDetails, HttpStatus.FORBIDDEN);

    }

    @ExceptionHandler(CustomerDoesNotHaveALoanException.class)
    public ResponseEntity<?> handleCustomerDoesNotHaveALoanException(CustomerDoesNotHaveALoanException e){
        CustomerDoesNotHaveALoanDetails customerDoesNotHaveALoanDetails = CustomerDoesNotHaveALoanDetails
                .CustomerDoesNotHaveALoanDetailsBuilder
                .newBuilder()
                .withTitle("CustomerDoesNotHaveALoanException")
                .withStatus(HttpStatus.NOT_FOUND.value())
                .withMessage(e.getMessage())
                .withTimestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(customerDoesNotHaveALoanDetails, HttpStatus.NOT_FOUND);
    }


}
