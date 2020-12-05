package com.gracie.ecommerce.data.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Order{
    @Id
    private Integer id;

    @OneToMany
    private List<Product> products;
}
