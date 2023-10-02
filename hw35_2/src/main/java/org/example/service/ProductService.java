package org.example.service;


import org.example.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();

    Page<Product> getProductsPage(Pageable page);

    Product getProductById(Long id);

}
