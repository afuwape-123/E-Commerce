package com.gracie.ecommerce.service;

import com.gracie.ecommerce.data.model.User;
import com.gracie.ecommerce.data.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.mockito.Mockito.*;


import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;


class UserServiceImplTest {
    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;

    User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        user = new User();
    }

    @Test
    void mockTestSaveUser(){
        when(userRepository.save(user)).thenReturn(user);

        userService.saveUser(user);

       verify(userRepository, times(1)).save(user);
    }

    @Test
    void mockDeleteUserTest(){
        doNothing().when(userRepository).deleteById(user.getId());

        userService.deleteUser(user.getId());

        verify(userRepository, times(1)).deleteById(user.getId());
    }
}