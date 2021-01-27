package com.gracie.ecommerce.service;

import com.gracie.ecommerce.data.model.Cart;
import com.gracie.ecommerce.data.model.Product;

import java.util.List;

public interface CartService {

    Cart saveCart(Cart cart);

    void deleteCart(Cart cart);

    Cart addProductToCart(Product product, Integer cartId) throws Exception;
    List<Cart> findAllProductInCart();
}
