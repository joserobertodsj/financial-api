package com.minsait.financial.models.dtos.responses.customer;

import com.minsait.financial.models.AddressEmbeddable;
import com.minsait.financial.models.dtos.responses.loan.LoanResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerResponseDto {
    private Long id;
    private String name;
    private String documentNumber;
    private String phoneNumber;
    private BigDecimal monthlyIncome;
    private AddressEmbeddable address;
    private List<LoanResponseDto> loans;
}
