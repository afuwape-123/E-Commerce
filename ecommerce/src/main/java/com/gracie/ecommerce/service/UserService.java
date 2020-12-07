package com.gracie.ecommerce.service;

import com.gracie.ecommerce.data.model.User;

public interface UserService {
    User saveUser(User user);

    void deleteUser(User user);
}
