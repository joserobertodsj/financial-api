package com.minsait.financial.models;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AddressEmbeddable {
    @NotBlank(message = "Preenchimento obrigatório.")
    private String street;
    @NotBlank(message = "Preenchimento obrigatório.")
    private String number;
    @NotBlank(message = "Preenchimento obrigatório.")
    private String zipCode;
}
