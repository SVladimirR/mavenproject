package org.example.service;

import org.example.Order;

import java.util.List;

public interface OrderService {
    Order getOrderById(Long id);
    List<Order> getAllOrders();
    void addOrder(Order order);
}
