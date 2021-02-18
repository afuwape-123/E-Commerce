package com.gracie.ecommerce.Dto;

import com.gracie.ecommerce.data.model.User;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class DtoUserMapper {
    public static User convertDtoUserRegistrationTouser(DtoUserRegistration dtoUserRegistration){
     User user = new User();
     user.setEmail(dtoUserRegistration.getEmail());
      user.setFirstName(dtoUserRegistration.getFirstName());
      user.setLastName(dtoUserRegistration.getLastName());
      user.setPassword(dtoUserRegistration.getPassword());
      return user;
    }
}
