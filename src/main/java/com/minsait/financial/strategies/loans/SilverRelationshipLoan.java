package com.minsait.financial.strategies.loans;

import com.minsait.financial.models.LoanModel;


import java.math.BigDecimal;
import java.math.MathContext;

public class SilverRelationshipLoan implements LoanStrategy {
    @Override
    public BigDecimal calculateFinalValue(LoanModel loan) {
        BigDecimal loanInitialValue = loan.getInitialValue();

        if(loanInitialValue.compareTo(BigDecimal.valueOf(5000.00)) == 1){
            return loanInitialValue.multiply(BigDecimal.valueOf(1.40), MathContext.DECIMAL32);
        }
        return loanInitialValue.multiply(BigDecimal.valueOf(1.60), MathContext.DECIMAL32);
    }
}
