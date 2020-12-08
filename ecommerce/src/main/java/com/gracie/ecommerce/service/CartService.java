package com.gracie.ecommerce.service;

import com.gracie.ecommerce.data.model.Cart;

public interface CartService {

    Cart saveCart(Cart cart);

    void deleteCart(Cart cart);
}
