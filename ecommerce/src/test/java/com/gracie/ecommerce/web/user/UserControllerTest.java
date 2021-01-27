package com.gracie.ecommerce.web.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gracie.ecommerce.data.model.User;
import com.gracie.ecommerce.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = "classpath:db/insert.sql")
public class UserControllerTest {
    @Autowired
    UserServiceImpl userService;


    @Autowired
    private MockMvc mockMvc;

    ObjectMapper mapper = new ObjectMapper();


    @BeforeEach
    void setUp() {

    }
//        @Test
//        void whenICallTheCreatePostMethodThenCreateAUserObject() throws Exception{
//
//        User user = new User();
//        user.setFirstName("Adewale");
//        user.setLastName("Adekunle");
//        user.setEmail("airtale123@gmail.com");
//        user.setPassword("ringing");
//
//
//        this.mockMvc.perform(post("/user/create")
//                .contentType("application/json")
//                .content(mapper.writeValueAsString(user)))
//                .andDo(print())
//                .andExpect(status().isCreated())
//                .andReturn();
//
//        }


        @Test
        void deleteUser() throws Exception{
            this.mockMvc.perform(delete("/user/deleteUser/3"))
                    .andDo(print())
                    .andExpect(status().isOk());
        }

        @Test
        void checkUser() throws Exception{
          this.mockMvc.perform(post("/user/checkUser/4"))
                  .andDo(print())
                  .andExpect(status().isOk())
                  .andReturn();
        }
}
