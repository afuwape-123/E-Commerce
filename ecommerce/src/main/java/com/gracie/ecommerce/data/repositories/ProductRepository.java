package com.gracie.ecommerce.data.repositories;

import com.gracie.ecommerce.data.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
