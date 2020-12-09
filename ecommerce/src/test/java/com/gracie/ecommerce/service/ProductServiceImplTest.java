package com.gracie.ecommerce.service;

import com.gracie.ecommerce.data.model.Product;
import com.gracie.ecommerce.data.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.verification.VerificationMode;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceImplTest {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductServiceImpl productService;

    Product product;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        product = new Product();
    }

    @Test
    void mockTestSaveProduct(){
    when(productRepository.save(product)).thenReturn(product);

        productService.saveProduct(product);

        verify(productRepository, times(1)).save(product);
    }
    @Test
    void mockTestDeleteProduct(){
        doNothing().when(productRepository).delete(product);

        productService.deleteProduct(product);

        verify(productRepository, times(1)).delete(product);
    }



}