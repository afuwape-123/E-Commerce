package com.gracie.ecommerce.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoUserRegistration {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
}
