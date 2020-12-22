package com.gracie.ecommerce.service;

import com.gracie.ecommerce.Dto.DtoUserRegistration;
import com.gracie.ecommerce.data.model.User;

import java.util.Optional;

public interface UserService {

    User saveUser(User user);

    void deleteUser(User user);

    User registerUser(DtoUserRegistration dtoUserRegistration) throws Exception;

    Optional<User> checkIfUserExistsByEmail(String email);
}

