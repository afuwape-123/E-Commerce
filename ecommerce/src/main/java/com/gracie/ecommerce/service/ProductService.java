package com.gracie.ecommerce.service;

import com.gracie.ecommerce.data.model.Product;

public interface ProductService {

    Product saveProduct(Product product);

    void deleteProduct(Product product);
}
