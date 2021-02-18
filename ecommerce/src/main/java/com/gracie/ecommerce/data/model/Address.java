package com.gracie.ecommerce.data.model;

import lombok.Data;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany
    private List<User> addressOwners;
}
