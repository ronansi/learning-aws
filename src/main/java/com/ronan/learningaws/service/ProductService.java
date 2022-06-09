package com.ronan.learningaws.service;

import com.ronan.learningaws.model.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    private final Map<Long, Product> database = new HashMap<>();

    public ProductService() {
        database.put(1L, new Product(1L, "Product 1", new BigDecimal("10.00")));
        database.put(2L, new Product(2L, "Product 2", new BigDecimal("20.00")));
        database.put(3L, new Product(3L, "Product 3", new BigDecimal("30.00")));
    }

    public Product save(Product product) {
        product.setId(database.size() + 1L);
        database.put(product.getId(), product);
        return product;
    }

    public Product alterProduct(Long id, Product product) {
        product.setId(id);
        database.put(id, product);
        return product;
    }

    public Product getProductById(Long id) {
        return database.get(id);
    }

    public List<Product> listAllProducts() {
        return new ArrayList<>(database.values());
    }

    public void deleteProduct(Long id) {
        database.remove(id);
    }

}
