package com.minsait.financial.models.dtos.requests.loan;

import com.minsait.financial.enums.Relationship;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoanRequestDto {
    @NotBlank(message = "Preenchimento obrigatório.")
    private String customerDocumentNumber;
    @NotNull(message = "Preenchimento obrigatório.")
    private BigDecimal initialValue;
    @NotNull(message = "Preenchimento obrigatório.")
    private LocalDate initialDate;
    @NotNull(message = "Preenchimento obrigatório.")
    private LocalDate finalDate;
    @NotNull(message = "Preenchimento obrigatório.")
    @Enumerated(EnumType.STRING)
    private Relationship relationship;
}
