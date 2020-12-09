package com.gracie.ecommerce.service;

import com.gracie.ecommerce.data.model.Cart;
import com.gracie.ecommerce.data.repositories.CartRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CartServiceImplTest {
    @Mock
    CartRepository cartRepository;

    @InjectMocks
    CartServiceImpl cartService;

    Cart cart;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        cart = new Cart();
    }

    @Test
    void mockTestSaveCart(){
        when(cartRepository.save(cart)).thenReturn(cart);

        cartService.saveCart(cart);

        verify(cartRepository, times(1)).save(cart);

    }

    @Test
    void mockTestDeleteCart(){
        doNothing().when(cartRepository).delete(cart);

        cartService.deleteCart(cart);

        verify(cartRepository, times(1)).delete(cart);
    }
}