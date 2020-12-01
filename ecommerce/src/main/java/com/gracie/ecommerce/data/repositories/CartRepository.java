package com.gracie.ecommerce.data.repositories;

import com.gracie.ecommerce.data.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
}
