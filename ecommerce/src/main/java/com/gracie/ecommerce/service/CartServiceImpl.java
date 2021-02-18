package com.gracie.ecommerce.service;

import com.gracie.ecommerce.Exceptions.CartException;
import com.gracie.ecommerce.data.model.Cart;
import com.gracie.ecommerce.data.model.Product;
import com.gracie.ecommerce.data.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;


    @Override
    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);

    }

    @Override
    public void deleteCart(Integer cartId) {
        cartRepository.deleteById(cartId);

    }

    @Override
    public Optional<Cart> findCartById(Integer id) {

        return cartRepository.findById(id);
    }

//    @Override
//    public Cart addProductToCart(Product product, Integer cartId) throws Exception {
////        if (!cartRepository.existsById(cartId)) {
////            throw new CartException("Cart does not exist");
////        }
////        else {
//            Cart cart = findCartById(cartId);
//            assert cart != null;
//            cart.getProducts().add(product);
//           return saveCart(cart);
//
//
////        }
////      return cartRepositoryaddProductToCart(product,cartId);
//
//    }

    public Cart addProductToCart(Product product, Integer CartId){
        Optional<Cart> optionalCart = findCartById(CartId);

        Cart cart = optionalCart.get();

        cart.getProducts().add(product);

        return saveCart(cart);
    }

    @Override
    public List<Cart> findAllProductInCart() {

        return cartRepository.findAll();
    }
}
