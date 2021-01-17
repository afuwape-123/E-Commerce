package com.gracie.ecommerce.service;

import com.gracie.ecommerce.Dto.DtoUserMapper;
import com.gracie.ecommerce.Dto.DtoUserRegistration;
import com.gracie.ecommerce.Exceptions.RegisterException;
import com.gracie.ecommerce.data.model.Role;
import com.gracie.ecommerce.data.model.User;
import com.gracie.ecommerce.data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
//import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;



    PasswordEncoder passwordEncoder;


//    @Autowired
//    DtoUserMapper dtoUserMapper;

    @Override
    public User saveUser(User user) {

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {

        userRepository.delete(user);
    }

    @Override
    public User registerUser(DtoUserRegistration dtoUserRegistration) throws RegisterException {
        Optional<User> optionalUser = checkIfUserExistsByEmail(dtoUserRegistration.getEmail());


        if(optionalUser.isPresent()){

            throw new RegisterException("user already exist");

        }
        else{
           User newUser = DtoUserMapper.convertDtoUserRegistrationTouser(dtoUserRegistration);
            newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
            newUser.setRole(Role.USER);
           return saveUser(newUser);
        }
    }

    @Override
    public Optional<User> checkIfUserExistsByEmail(String email) {

        return userRepository.findByEmail(email);
    }


}
