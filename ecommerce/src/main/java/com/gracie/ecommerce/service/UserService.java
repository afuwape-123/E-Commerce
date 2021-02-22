package com.gracie.ecommerce.service;

import com.gracie.ecommerce.Dto.DtoUserRegistration;
import com.gracie.ecommerce.data.model.User;
import com.gracie.ecommerce.security.dtos.UserLoginRequestDTO;
import com.gracie.ecommerce.security.exception.AuthenticationException;
import com.gracie.ecommerce.security.exception.AuthorizationException;
import com.gracie.ecommerce.security.security.JWTToken;

import java.util.Optional;

public interface UserService {

    User saveUser(User user);

    void deleteUser(Integer id);

    User registerUser(DtoUserRegistration dtoUserRegistration) throws Exception;

    Optional<User> checkIfUserExistsByEmail(String email);

    JWTToken loginUser(UserLoginRequestDTO userLoginRequestDTO) throws AuthenticationException, AuthorizationException;

}

