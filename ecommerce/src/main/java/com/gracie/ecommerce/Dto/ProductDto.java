package com.gracie.ecommerce.Dto;


import com.gracie.ecommerce.data.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductDto {
    private String productName;
    private Integer quantity;
    private Category category;
}
