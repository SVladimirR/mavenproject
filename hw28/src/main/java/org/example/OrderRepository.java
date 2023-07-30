package org.example;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    private final List<Order> orders;

    public OrderRepository() {
        this.orders = new ArrayList<>();
    }

    public Order getOrderById(int orderId) {
        for (Order order : orders) {
            if (order.getId() == orderId) {
                return order;
            }
        }
        return null;
    }

    public List<Order> getAllOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
}
