package com.minsait.financial.strategies.loans;

import com.minsait.financial.exceptions.GoldRelationshipLoanNotAllowedException;
import com.minsait.financial.models.LoanModel;

import java.math.BigDecimal;
import java.math.MathContext;

public class GoldRelationshipLoan implements LoanStrategy {
    @Override
    public BigDecimal calculateFinalValue(LoanModel loan) {
        BigDecimal loanInitialValue = loan.getInitialValue();
        int loanAmount = loan.getCustomerModel().getLoans().size();
        if(loanAmount == 1){
            return loanInitialValue.multiply(BigDecimal.valueOf(1.20), MathContext.DECIMAL32);
        } else if (loanAmount > 1) {
            return loanInitialValue.multiply(BigDecimal.valueOf(1.30), MathContext.DECIMAL32);
        }
        throw new GoldRelationshipLoanNotAllowedException("Histórico de empréstimo inexistente. Você não pode contratar o relacionamento GOLD");
    }

}

