package com.gracie.ecommerce.Dto;

import com.gracie.ecommerce.data.model.User;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class DtoUserMapper {
    public static User convertDtoUserRegistrationTouser(DtoUserRegistration dtoUserRegistration){
      User user = new User();
      dtoUserRegistration.setEmail(dtoUserRegistration.getEmail().toLowerCase());
      dtoUserRegistration.setFirstName(dtoUserRegistration.getFirstName());
      dtoUserRegistration.setLastName(dtoUserRegistration.getLastName());
      dtoUserRegistration.setPassword(dtoUserRegistration.getPassword());
      return user;
    }
}
