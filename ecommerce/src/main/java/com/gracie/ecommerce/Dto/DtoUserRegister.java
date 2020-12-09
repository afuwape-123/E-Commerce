package com.gracie.ecommerce.Dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


import java.beans.ConstructorProperties;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoUserRegister {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
