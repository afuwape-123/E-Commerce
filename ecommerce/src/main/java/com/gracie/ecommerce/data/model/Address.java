package com.gracie.ecommerce.data.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
@Data
@Entity
public class Address {
    @Id
    private Integer id;
    private Integer house_no;
    private String streetName;
    private String city;
    private String state;
    private String postal_code;
}
