package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.Order;
import org.example.service.OrderService;
import org.example.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderServiceImpl orderRepository) {
        this.orderService = orderRepository;
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        log.info("call method get by ID...");
        return orderService.getOrderById(id);
    }

    @GetMapping("/")
    public List<Order> getAllOrders() {
        log.info("call method get All...");
        return orderService.getAllOrders();
    }

    @PostMapping("/")
    public void addOrder(@RequestBody Order order) {
        orderService.addOrder(order);
        log.info("call method add ...");
    }

}
