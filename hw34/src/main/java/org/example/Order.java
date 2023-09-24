package org.example;

import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class Order {
    private Long id;
    private Date date;
    private double cost;
    private List<Product> products;
}

