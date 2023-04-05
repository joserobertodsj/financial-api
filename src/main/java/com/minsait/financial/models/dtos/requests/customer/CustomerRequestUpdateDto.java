package com.minsait.financial.models.dtos.requests.customer;

import com.minsait.financial.models.AddressEmbeddable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerRequestUpdateDto {
    @NotBlank(message = "Preenchimento obrigatório.")
    private String name;
    @NotBlank(message = "Preenchimento obrigatório.")
    private String phoneNumber;
    @DecimalMin(value = "0.0" , inclusive = false)
    @Digits(integer = 20, fraction = 2)
    @NotNull(message = "Preenchimento obrigatório." )
    private BigDecimal monthlyIncome;
    @Valid
    private AddressEmbeddable address;
}
