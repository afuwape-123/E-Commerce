package com.gracie.ecommerce.data.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    private Integer id;

    private String productName;
    private Integer quantity;
    private Category categories;
}
