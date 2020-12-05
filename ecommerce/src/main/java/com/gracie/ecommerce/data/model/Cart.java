package com.gracie.ecommerce.data.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Data
@Entity
public class Cart {
    @Id
    private Integer Id;

    @OneToOne
    private User cartOwner;

    @OneToMany
    private List<Product>  products;
}
