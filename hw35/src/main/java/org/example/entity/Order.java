package org.example.entity;


import lombok.Data;
import jakarta.persistence.*;


import java.util.List;

@Entity
@Data
@Table(name = "basket1")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    private Double cost;

    @ManyToMany
    @JoinTable(
            name = "purchase1",
            joinColumns = @JoinColumn(name = "basket_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;
}




