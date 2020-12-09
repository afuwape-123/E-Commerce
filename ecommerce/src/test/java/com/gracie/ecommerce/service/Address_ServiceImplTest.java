package com.gracie.ecommerce.service;

import com.gracie.ecommerce.data.model.Address;
import com.gracie.ecommerce.data.repositories.AddressRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class Address_ServiceImplTest {
    @Mock
    AddressRepository addressRepository;

    @InjectMocks
    Address_ServiceImpl address_service;

    Address address;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        address = new Address();
    }
    @Test
     void mockTestSaveAddress(){

        when(addressRepository.save(address)).thenReturn(address);

        address_service.saveAddress(address);

        verify(addressRepository, times(1)).save(address);
    }

    @Test
    void mockTestDeleteAddress(){
        doNothing().when(addressRepository).delete(address);

        address_service.deleteAddress(address);

        verify(addressRepository, times(1)).delete(address);
    }
}