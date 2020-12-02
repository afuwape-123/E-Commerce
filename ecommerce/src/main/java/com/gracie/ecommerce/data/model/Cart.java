package com.gracie.ecommerce.data.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Cart {
    @Id
    private Integer Id;

    @OneToMany
    private List<Product>  products;
}
