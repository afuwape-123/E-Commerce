package com.gracie.ecommerce.service;

import com.gracie.ecommerce.Exceptions.CartException;
import com.gracie.ecommerce.data.model.Cart;
import com.gracie.ecommerce.data.model.Product;
import com.gracie.ecommerce.data.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
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
    public Cart findCartById(Integer id) {

        return cartRepository.findById(id).orElse(null);
    }

    @Override
    public Cart addProductToCart(Product product, Integer cartId) throws Exception {
        Cart cart = findCartById(cartId);
            assert cart != null;
            cart.getProducts().add(product);
           return saveCart(cart);

    }

   private void doesCartExist(Integer cartId) throws CartException {
        if (!cartRepository.existsById(cartId)) {
            throw new CartException("Cart does not exist");
        }
    }

    @Override
    public List<Cart> findAllProductInCart() {
        return cartRepository.findAll();
    }
}
