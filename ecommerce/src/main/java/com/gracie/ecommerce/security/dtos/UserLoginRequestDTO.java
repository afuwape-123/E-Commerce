package com.gracie.ecommerce.security.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UserLoginRequestDTO {
    private String email;
    private String password;
}
