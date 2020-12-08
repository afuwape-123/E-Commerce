package com.gracie.ecommerce.service;

import com.gracie.ecommerce.data.model.Order;

public interface OrderService  {
    Order saveOrder(Order order);

    void deleteOrder(Order order);
}
