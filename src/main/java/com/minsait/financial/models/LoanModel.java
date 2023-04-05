package com.minsait.financial.models;

import com.minsait.financial.enums.Relationship;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tb_loan")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoanModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private CustomerModel customerModel;
    private String customerDocumentNumber;
    private BigDecimal initialValue;
    private BigDecimal finalValue;
    private LocalDate initialDate;
    private LocalDate finalDate;
    @Enumerated
    private Relationship relationship;


}
