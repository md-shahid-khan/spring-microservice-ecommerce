package com.codominator.usermicroservice.dto.response;

import com.codominator.usermicroservice.entity.Address;
import com.codominator.usermicroservice.entity.UserRole;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class UserResponseDto {
    private String username;
    private String email;
    private String phone;
    private UserRole userRole;
    private Address address;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
