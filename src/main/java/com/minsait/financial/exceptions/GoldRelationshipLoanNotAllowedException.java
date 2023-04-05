package com.minsait.financial.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class GoldRelationshipLoanNotAllowedException extends RuntimeException {
    public GoldRelationshipLoanNotAllowedException(String message) {
        super(message);
    }
}
