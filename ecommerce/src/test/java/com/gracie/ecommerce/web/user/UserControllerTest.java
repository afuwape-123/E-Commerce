package com.gracie.ecommerce.web.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gracie.ecommerce.Dto.DtoUserRegistration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.convert.ThreeTenBackPortConverters;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    ObjectMapper mapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("When user passes in details through dto, API should register user")
    void testThatUserCanRegister() throws Exception {
        DtoUserRegistration dtoUserRegistration = new DtoUserRegistration();
        dtoUserRegistration.setEmail("ganiu@gmail.com");
        dtoUserRegistration.setFirstName("Ganiu");
        dtoUserRegistration.setLastName("Afuwape");
        dtoUserRegistration.setPassword("GanGaraga");


        this.mockMvc.perform(post("/user/registerUser")
                .contentType("application/json")
                .content(mapper.writeValueAsString(dtoUserRegistration)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andReturn();
    }
}