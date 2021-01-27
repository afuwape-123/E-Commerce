package com.gracie.ecommerce.service;

import com.gracie.ecommerce.Exceptions.CartException;
import com.gracie.ecommerce.data.model.Cart;
import com.gracie.ecommerce.data.model.Product;
import com.gracie.ecommerce.data.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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

    @Override
    public Cart addProductToCart(Product product, Integer cartId) throws Exception {
        if(!cartRepository.existsById(cartId)){
            throw new CartException("Cart does not exist");
        }
        else{
            Cart cart = cartRepository.findById(cartId).orElse(null);
                    assert cart != null;
                    cart.getProducts().add(product);

                    return cart;

        }
    }

    @Override
    public List<Cart> findAllProductInCart() {
        return cartRepository.findAll();
    }
}
