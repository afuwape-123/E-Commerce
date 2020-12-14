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

    private String lastName;

    private String  email;

    private String password;

    private Role role;

    @OneToMany
    private List<Address> address;

    @OneToOne
    private Cart cart;
}