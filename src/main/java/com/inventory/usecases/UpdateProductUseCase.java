package com.inventory.usecases;

import com.inventory.domain.Product;
import com.inventory.domain.ProductRepository;

public class UpdateProductUseCase {
    private final ProductRepository repo;

    public UpdateProductUseCase(ProductRepository repo) { this.repo = repo; }

    public boolean execute(Product product) {
        if (repo.findById(product.getId()) == null) return false;
        return repo.update(product);
    }
}
