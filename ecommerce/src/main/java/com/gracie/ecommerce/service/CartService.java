package com.gracie.ecommerce.service;

import com.gracie.ecommerce.data.model.Cart;
import com.gracie.ecommerce.data.model.Product;

import java.util.List;
import java.util.Optional;

public interface CartService {

    Cart saveCart(Cart cart);

    void deleteCart(Integer cartId);

    Optional<Cart> findCartById(Integer id);

    Cart addProductToCart(Product product, Integer cartId) throws Exception;

    List<Cart> findAllProductInCart();
}
