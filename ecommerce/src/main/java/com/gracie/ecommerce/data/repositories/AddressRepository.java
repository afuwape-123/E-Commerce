package com.gracie.ecommerce.data.repositories;

import com.gracie.ecommerce.data.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
