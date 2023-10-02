package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.exceptions.ProductNotFoundException;
import org.example.repository.ProductRepository;
import org.example.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import org.example.entity.Product;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Override
    public List<Product> getProducts() {
        return repository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("COULD NOT FOUND PRODUCT"));
    }

    @Override
    public Page<Product> getProductsPage(Pageable page) {
        return repository.findAll(page);
    }
}