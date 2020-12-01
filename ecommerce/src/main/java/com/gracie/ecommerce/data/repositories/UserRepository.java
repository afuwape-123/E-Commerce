package com.gracie.ecommerce.data.repositories;

import com.gracie.ecommerce.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
