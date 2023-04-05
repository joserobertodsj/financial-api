package com.minsait.financial.strategies.loans;

import com.minsait.financial.models.LoanModel;

import java.math.BigDecimal;
import java.math.MathContext;

public class BronzeRelationshipLoan implements LoanStrategy {


    @Override
    public BigDecimal calculateFinalValue(LoanModel loan) {
        return loan.getInitialValue().multiply(BigDecimal.valueOf(1.80), MathContext.DECIMAL32);
    }
}
