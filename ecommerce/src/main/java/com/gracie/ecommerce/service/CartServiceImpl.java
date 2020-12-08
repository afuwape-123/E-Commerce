package com.gracie.ecommerce.service;

import com.gracie.ecommerce.data.model.Cart;
import com.gracie.ecommerce.data.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Override
    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);

    }

    @Override
    public void deleteCart(Cart cart) {
        cartRepository.delete(cart);

    }
}
