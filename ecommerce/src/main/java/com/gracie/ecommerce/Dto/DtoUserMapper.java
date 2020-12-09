package com.gracie.ecommerce.Dto;

import com.gracie.ecommerce.data.model.User;
import lombok.Data;



public class DtoUserMapper {
    public static User convertUserDtoToUser(DtoUserRegister dtoUserRegister){

        User user = new User();
        user.setEmail(dtoUserRegister.getEmail().toLowerCase());
        user.setFirstName(dtoUserRegister.getFirstName());
        user.setLastname(dtoUserRegister.getLastName());
        user.setPassword(dtoUserRegister.getPassword());
        return user;
    }
}
