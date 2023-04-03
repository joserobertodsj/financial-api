package com.minsait.financial.models.dtos.requests.address;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddressRequestDto {
    @NotBlank(message = "Preenchimento obrigatório.")
    private String street;
    @NotBlank(message = "Preenchimento obrigatório.")
    private String number;
    @NotBlank(message = "Preenchimento obrigatório.")
    private String zipCode;
    @JsonIgnore
    private Long idCustomer;
}
