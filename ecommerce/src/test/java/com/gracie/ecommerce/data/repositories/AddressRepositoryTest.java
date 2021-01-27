package com.gracie.ecommerce.data.repositories;

import com.gracie.ecommerce.data.model.Address;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@SpringBootTest
@Sql(scripts = "classpath:db/insert.sql")
class AddressRepositoryTest {
 @Autowired
    Address address;
 @Autowired
 AddressRepository addressRepository;
    @BeforeEach
    void setUp() {
    }

    @Test
    void thatICanCreateAddress(){
    address.setCity("Yaba");
    address.setHouse_no(20);
    address.setState("Lagos");
    address.setStreetName("Oyadiran");
    address.setPostal_code("20021");
    log.info("object before saving --> {}", address);
    addressRepository.save(address);
    assertThat(address.getId()).isNotNull();
    }
}