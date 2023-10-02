package org.example.entity;


import lombok.Data;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "product2")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Double price;
}
