package com.inventory.domain;

import java.util.List;

public interface ProductRepository {
    boolean add(Product product);
    boolean update(Product product);
    boolean delete(String id);
    Product findById(String id);
    List<Product> findAll();
}
