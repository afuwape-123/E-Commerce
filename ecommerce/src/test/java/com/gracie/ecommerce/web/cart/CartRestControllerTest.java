package com.gracie.ecommerce.web.cart;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gracie.ecommerce.data.model.Cart;
import com.gracie.ecommerce.data.model.User;
import com.gracie.ecommerce.service.CartServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class CartRestControllerTest {

//    @Autowired
    CartServiceImpl cartServiceImpl = new CartServiceImpl();

    @Autowired
    private MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {

    }

    @Test
    void deleteCart() throws Exception{
//        Cart cart = new Cart();
//        cart.setId(4);
//        cart.setCartOwner(new User());
//        cartServiceImpl.saveCart(cart);


        this.mockMvc.perform(delete("/cart/deleteCart/1"))
                    .andDo(print())
                    .andExpect(status().isOk());
    }

}