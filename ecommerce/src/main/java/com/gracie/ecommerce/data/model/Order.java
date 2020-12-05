package com.gracie.ecommerce.data.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Order{
    @Id
    private Integer user_id;

    private String order_date;
    private String user_card;
}
