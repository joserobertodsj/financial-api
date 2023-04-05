package com.minsait.financial.models.dtos.responses.loan;

import com.minsait.financial.enums.Relationship;
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
public class LoanResponseDto {
    private Long id;
    private String customerDocumentNumber;
    private BigDecimal initialValue;
    private BigDecimal finalValue;
    private LocalDate initialDate;
    private LocalDate finalDate;
    private Relationship relationship;
}
