package com.gracie.ecommerce.service;

import com.gracie.ecommerce.data.model.Address;
import com.gracie.ecommerce.data.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class Address_ServiceImpl implements Address_Service{

    @Autowired
    AddressRepository addressRepository;


    @Override
    public Address saveAddress(Address address) {
        return addressRepository.save(address);

    }

    @Override
    public void deleteAddress(Address address) {
    addressRepository.delete(address);

    }

}
