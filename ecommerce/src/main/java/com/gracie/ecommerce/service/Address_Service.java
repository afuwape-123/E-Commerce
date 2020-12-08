package com.gracie.ecommerce.service;

import com.gracie.ecommerce.data.model.Address;

public interface Address_Service {

    Address saveAddress(Address address);

    void deleteAddress(Address address);
}
