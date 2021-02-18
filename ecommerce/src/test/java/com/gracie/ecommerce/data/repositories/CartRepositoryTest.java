package com.gracie.ecommerce.data.repositories;

import com.gracie.ecommerce.data.model.Cart;
import com.gracie.ecommerce.data.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class CartRepositoryTest {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    UserRepository userRepository;

    Cart cart;

    @BeforeEach
    void setUp() {
        cart = new Cart();

    }

    @Test
    void testThatWeCanCreateACart(){
        User user = userRepository.findById(2).orElse(null);
        cart.setId(1);
        cart.setCartOwner(user);
        cartRepository.save(cart);
        log.info("Cart after saving ->{}",cart);
    }
}