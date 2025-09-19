package com.inventory.adapters.persistence;

import com.inventory.domain.Product;
import com.inventory.domain.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ProductRepositoryImpl implements ProductRepository {
    private final ConcurrentMap<String, Product> store = new ConcurrentHashMap<>();

    @Override
    public boolean add(Product product) {
        return store.putIfAbsent(product.getId(), product) == null;
    }

    @Override
    public boolean update(Product product) {
        return store.computeIfPresent(product.getId(), (k, old) -> {
            old.setName(product.getName());
            old.setPrice(product.getPrice());
            old.setStock(product.getStock());
            return old;
        }) != null;
    }

    @Override
    public boolean delete(String id) {
        return store.remove(id) != null;
    }

    @Override
    public Product findById(String id) {
        return store.get(id);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(store.values());
    }
}
