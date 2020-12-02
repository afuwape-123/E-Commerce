package com.gracie.ecommerce.data.model;

import lombok.Data;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Data
@Entity
@Service
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer house_no;
    private String streetName;
    private String city;
    private String state;
    private String postal_code;
}
