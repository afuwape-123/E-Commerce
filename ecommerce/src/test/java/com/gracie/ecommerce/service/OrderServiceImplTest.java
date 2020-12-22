//package com.gracie.ecommerce.service;
//
////import com.gracie.ecommerce.data.model.Order;
////import com.gracie.ecommerce.data.repositories.OrderRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//class OrderServiceImplTest {
//
//    @Mock
//    OrderRepository orderRepository;
//
//    @InjectMocks
//    OrderServiceImpl orderService;
//
//    Order order;
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//        order = new Order();
//    }
//
//    @Test
//    void mockTestSaveOrder(){
//        when(orderRepository.save(order)).thenReturn(order);
//
//        orderService.saveOrder(order);
//
//        verify(orderRepository, times(1)).save(order);
//    }
//
//    @Test
//    void mockTestDeleteOrder(){
//        doNothing().when(orderRepository).delete(order);
//
//        orderService.deleteOrder(order);
//
//        verify(orderRepository, times(1)).delete(order);
//    }
//}