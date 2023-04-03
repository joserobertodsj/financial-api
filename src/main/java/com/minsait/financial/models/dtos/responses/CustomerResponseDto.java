package com.minsait.financial.models.dtos.responses;

import com.minsait.financial.models.AddressEmbeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerResponseDto {

    private String name;
    private String documentNumber;
    private String phoneNumber;
    private BigDecimal monthlyIncome;
    private AddressEmbeddable address;
}
