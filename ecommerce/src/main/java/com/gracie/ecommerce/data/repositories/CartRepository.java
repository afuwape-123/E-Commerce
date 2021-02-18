package com.gracie.ecommerce.data.repositories;

import com.gracie.ecommerce.Exceptions.CartException;
import com.gracie.ecommerce.data.model.Cart;
import com.gracie.ecommerce.data.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface CartRepository extends JpaRepository<Cart, Integer> {


}
