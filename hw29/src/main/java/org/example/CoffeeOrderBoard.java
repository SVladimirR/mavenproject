package org.example;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.ArrayList;
import java.util.List;


public class CoffeeOrderBoard {

    private static final Logger logger = LoggerFactory.getLogger("logger");
    private final List<Order> orders;
    private int orderNumber;

    public CoffeeOrderBoard() {
        this.orders = new ArrayList<>();
        this.orderNumber = 1;
    }

    public void add(String name) {
        try {
            Order order = new Order(orderNumber++, name);
            orders.add(order);
            logger.info("New order added - Order Number: {}, Name: {}", order.getOrderNumber(), order.getName());
        } catch (Exception e) {
            logger.error("An error occurred while adding a new order:", e);
        }
    }

    public void deliver() {
        if (!orders.isEmpty()) {
            Order order = orders.get(0);
            logger.info("Delivering order: {} - {}", order.getOrderNumber(), order.getName());
//            System.out.println("Delivering order: " + order.getOrderNumber() + " - " + order.getName());
            orders.remove(0);
        } else {
//            System.out.println("No orders to deliver.");
            logger.info("No orders to deliver.");
        }
    }

    public void deliver(int orderNumber) {
        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            if (order.getOrderNumber() == orderNumber) {
//                System.out.println("Delivering order: " + order.getOrderNumber() + " - " + order.getName());
                logger.info("Delivering order: {} - {}", order.getOrderNumber(), order.getName());
                orders.remove(i);
                return;
            }
        }
//        System.out.println("Order " + orderNumber + " not found.");
        logger.info("Order {} not found.", orderNumber);
    }

    public void draw() {
//        System.out.println("Num : Name");
        logger.info("Num : Name");
        for (Order order : orders) {
//            System.out.println(order.getOrderNumber() + " : " + order.getName());
            logger.info("{} : {}", order.getOrderNumber(), order.getName());
        }
    }
}
