package com.minsait.financial.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_customer", uniqueConstraints={@UniqueConstraint(columnNames={"documentNumber"})})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String documentNumber;
    private String phoneNumber;
    private BigDecimal monthlyIncome;
    @Embedded
    private AddressEmbeddable address;
}
