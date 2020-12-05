package com.gracie.ecommerce.data.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
@Data
@Entity
public class User {
    @Id
    private Integer id;
    private String userName;
    private Integer contact;
    private String firstName;
    private String lastname;
    private String  email;

}