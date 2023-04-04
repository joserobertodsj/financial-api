package com.minsait.financial.exceptions.handler;

import com.minsait.financial.exceptions.CustomerNotFoundException;
import com.minsait.financial.exceptions.details.CustomerNotFoundDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<?> handleDocumentNumberNotFoundException(CustomerNotFoundException e){
        CustomerNotFoundDetails customerNotFoundDetails = CustomerNotFoundDetails
                .CustomerNotFoundDetailsBuilder
                .newBuild()
                .withTitulo("CustomerNotFoundException")
                .withStatus(HttpStatus.NOT_FOUND.value())
                .withMensagem(e.getMessage())
                .withTimestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(customerNotFoundDetails, HttpStatus.NOT_FOUND);
    }
}
