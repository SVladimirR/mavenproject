package org.example.service.impl;


import org.example.Order;
import org.example.service.OrderService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderServiceImpl implements OrderService {
    private final List<Order> orders = new ArrayList<>();
    @Override

    public Order getOrderById(Long id) {

        return null;
    }
@Override
    public List<Order> getAllOrders() {

        return orders;
    }
@Override
    public void addOrder(Order order) {

        orders.add(order);
    }
}
