package com.gracie.ecommerce.Dto;


import com.gracie.ecommerce.data.model.Product;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class ProductDtoMapper {
    public static Product convertProductDtoToproduct(ProductDto productDto){
        Product product = new Product();
        productDto.setProductName(productDto.getProductName());
        productDto.setQuantity(productDto.getQuantity());
        productDto.setCategory(productDto.getCategory());
        return product;
    }
}
