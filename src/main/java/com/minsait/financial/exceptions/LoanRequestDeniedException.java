package com.minsait.financial.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.FORBIDDEN)
public class LoanRequestDeniedException extends RuntimeException {
    public LoanRequestDeniedException(String message) {
        super(message);
    }
}
