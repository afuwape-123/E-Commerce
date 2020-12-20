package com.gracie.ecommerce.service;

import com.gracie.ecommerce.Dto.ProductDto;
import com.gracie.ecommerce.Dto.ProductDtoMapper;
import com.gracie.ecommerce.data.model.Product;
import com.gracie.ecommerce.data.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;


    @Override
    public Product saveProduct(Product product) {


        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Product product) {
        productRepository.delete(product);

    }

    @Override
    public Product addProduct(ProductDto productDto){
       Product product = ProductDtoMapper.convertProductDtoToproduct(productDto);
       saveProduct(product);
       return product;
    }
    }

