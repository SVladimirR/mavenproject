package org.example;

import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class Order {
    private Long id;
    private String userName;
    private Double cost;
    private String description;
    private List<Product> products;
}

