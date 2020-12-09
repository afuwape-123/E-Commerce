package com.gracie.ecommerce.data.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer contact;

    private String firstName;

    private String lastname;

    private String  email;

    private String password;

    @OneToMany
    private List<Address> address;

    @OneToOne
    private Cart cart;
}