package com.minsait.financial.models.dtos.requests.customer;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerRequestDto {
    @NotBlank(message = "Preenchimento obrigatório.")
    private String name;
    @NotBlank(message = "Preenchimento obrigatório.")
    private String documentNumber;
    @NotBlank(message = "Preenchimento obrigatório.")
    private String phoneNumber;
    @NotBlank(message = "Preenchimento obrigatório.")
    private BigDecimal monthlyIncome;

}
