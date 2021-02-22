package com.gracie.ecommerce.service;

import com.gracie.ecommerce.Dto.DtoUserMapper;
import com.gracie.ecommerce.Dto.DtoUserRegistration;
import com.gracie.ecommerce.Exceptions.RegisterException;
import com.gracie.ecommerce.data.model.Role;
import com.gracie.ecommerce.data.model.User;
import com.gracie.ecommerce.data.repositories.UserRepository;
import com.gracie.ecommerce.security.dtos.UserLoginRequestDTO;
import com.gracie.ecommerce.security.exception.AuthenticationException;
import com.gracie.ecommerce.security.exception.AuthorizationException;
import com.gracie.ecommerce.security.security.JWTToken;
import com.gracie.ecommerce.security.security.UserPrincipalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserPrincipalService userPrincipalService;

    @Autowired
    UserRepository userRepository;



    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


//    @Autowired
//    DtoUserMapper dtoUserMapper;

    @Override
    public User saveUser(User user) {

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {

        userRepository.deleteById(id);
    }

    @Override
    public User registerUser(DtoUserRegistration dtoUserRegistration) throws RegisterException {
        User newUser;
        Optional<User> optionalUser = checkIfUserExistsByEmail(dtoUserRegistration.getEmail());


        if(optionalUser.isPresent()){

            throw new RegisterException("user already exist");

        }
        else{
           newUser = DtoUserMapper.convertDtoUserRegistrationTouser(dtoUserRegistration);
//            newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
            newUser.setRole(Role.USER);
           return saveUser(newUser);
        }
    }

    @Override
    public Optional<User> checkIfUserExistsByEmail(String email) {

        return userRepository.findByEmail(email);
    }

    @Override
    public JWTToken loginUser(UserLoginRequestDTO userLoginRequestDTO) throws AuthenticationException, AuthorizationException {

        return userPrincipalService.loginUser(userLoginRequestDTO);
    }




}
