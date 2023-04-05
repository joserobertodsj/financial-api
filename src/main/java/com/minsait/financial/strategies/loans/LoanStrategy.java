package com.minsait.financial.strategies.loans;

import com.minsait.financial.models.LoanModel;

import java.math.BigDecimal;

public interface LoanStrategy {
    BigDecimal calculateFinalValue(LoanModel loan);
}
