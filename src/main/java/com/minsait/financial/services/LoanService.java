package com.minsait.financial.services;

import com.minsait.financial.models.dtos.requests.loan.LoanRequestDto;
import com.minsait.financial.models.dtos.responses.loan.LoanResponseDto;

public interface LoanService {
    LoanResponseDto createLoan (String documentNumber, LoanRequestDto loanRequestDto);
    LoanResponseDto getLoanById(String documentNumber, Long id);
}
