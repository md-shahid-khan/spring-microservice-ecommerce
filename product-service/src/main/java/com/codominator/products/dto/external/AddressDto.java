package com.codominator.products.dto.external;

import lombok.Data;

@Data
public class AddressDto {
    private String street;
    private String zip;
    private String city;
    private String country;
    private String state;
}