package org.example;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/orders")

public class OrderController {
    private OrderRepository orderRepository;

    public OrderController() {
        this.orderRepository = new OrderRepository();
    }

    @GetMapping("/{orderId}")
    public Order getOrderById(@PathVariable int orderId) {
        return orderRepository.getOrderById(orderId);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    @PostMapping
    public void addOrder(@RequestBody Order order) {
        orderRepository.addOrder(order);
    }
}
