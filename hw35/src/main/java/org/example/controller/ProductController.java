package org.example.controller;


import org.example.entity.Product;
import org.example.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService service;

    @GetMapping
    public List<Product> getProducts() {
        log.info("Run method get all products");
        return service.getProducts();
    }


    @GetMapping("/page")
    public Page<Product> getProductsPage(@RequestParam("page") int page, @RequestParam("size") int size) {
        log.info("Run method get all products");
        return service.getProductsPage(PageRequest.of(page, size));
    }


    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        log.info("Run method get product by id");
        return service.getProductById(id);
    }
}
