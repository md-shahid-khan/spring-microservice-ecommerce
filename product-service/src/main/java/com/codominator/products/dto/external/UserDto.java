package com.codominator.products.dto.external;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserDto {
    private String username;
    private String email;
    private AddressDto address;
    private String phone;
}
