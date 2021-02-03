package com.gracie.ecommerce.service;

import com.gracie.ecommerce.data.model.Cart;
import com.gracie.ecommerce.data.model.Product;
import com.gracie.ecommerce.data.repositories.CartRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CartServiceImplTest {
    @Mock
    CartRepository cartRepository;

    @InjectMocks
    CartServiceImpl cartService;

    Cart cart;
    Product product;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        cart = new Cart();
        product = new Product();
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

    @Test
    void mockTestFindCartByIdTest(){
        when(cartRepository.findById(4)).thenReturn(Optional.of(cart));

        cartService.findCartById(4);

        verify(cartRepository, times(1)).findById(4);
    }

    @Test
     void mockTestAddProductToCartTest() throws Exception {
        List<Product> products = new ArrayList<>();

        Cart newCart = new Cart();
        newCart.setProducts(products);
        newCart.setId(1);
//        Cart savedCart = cartService.saveCart(cart);

//        when(cartRepository.existsById(1)).thenReturn(false);

        when(cartRepository.findById(1)).thenReturn(Optional.of(cart));
        when(cartRepository.save(cart)).thenReturn(cart);

        cartService.addProductToCart(product, 1);

        verify(cartRepository, times(1)).findById(1);
        verify(cartRepository, times(1)).save(cart);

    }

//    @Test
//    void testAddProductToCart(){
//        Integer productId = product.getId();
//        Cart cart = cartRepository.findById(cartId);
//        cart.getProducts().add(productId);
//
//    }
}