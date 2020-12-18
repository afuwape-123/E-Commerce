package com.gracie.ecommerce.data.repositories;

import com.gracie.ecommerce.Dto.DtoUserRegistration;
import com.gracie.ecommerce.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
   Optional<User> findByEmail();

}
