package org.example;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {
    private final List<Order> orders = new ArrayList<>();

    public Order getOrderById(Long id) {

        return null;
    }

    public List<Order> getAllOrders() {

        return orders;
    }

    public void addOrder(Order order) {

        orders.add(order);
    }
}
