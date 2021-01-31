package com.gracie.ecommerce.data.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
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


    @Email(message = "Invalid email")
    private String  email;

    private String password;

    private Role role;

    @OneToMany (cascade = CascadeType.PERSIST)
    private List<Address> address;

    @OneToOne
    private Cart cart;
}