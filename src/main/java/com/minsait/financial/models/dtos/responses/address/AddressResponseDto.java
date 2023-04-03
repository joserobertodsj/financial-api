package com.minsait.financial.models.dtos.responses.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddressResponseDto {
    private Long id;
    private String street;
    private String number;
    private String zipCode;
}
