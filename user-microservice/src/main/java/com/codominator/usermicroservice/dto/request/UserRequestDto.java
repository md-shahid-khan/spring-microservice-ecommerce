package com.codominator.usermicroservice.dto.request;

import com.codominator.usermicroservice.entity.UserRole;
import lombok.Data;

@Data
public class UserRequestDto {
    private String username;
    private String password;
    private String email;
    private String phone;
    private UserRole userRole;

    private AddressDto address;
}