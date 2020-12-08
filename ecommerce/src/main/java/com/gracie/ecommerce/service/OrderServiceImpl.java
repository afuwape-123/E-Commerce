package com.gracie.ecommerce.service;

import com.gracie.ecommerce.data.model.Order;
import com.gracie.ecommerce.data.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderServiceImpl implements OrderService  {

   @Autowired
   OrderRepository orderRepository;

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Order order) {
          orderRepository.delete(order);
    }
}
