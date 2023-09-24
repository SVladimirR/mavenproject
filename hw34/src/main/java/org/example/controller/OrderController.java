package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.Order;
import org.example.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@Slf4j
public class OrderController {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderRepository.getOrderById(id);
    }

    @GetMapping("/")
    public List<Order> getAllOrders() {
        log.info("call method ...");
        return orderRepository.getAllOrders();
    }

    @PostMapping("/")
    public void addOrder(@RequestBody Order order) {
        orderRepository.addOrder(order);
        log.info("call method add ...");
    }

}
