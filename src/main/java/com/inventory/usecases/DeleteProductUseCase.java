package com.inventory.usecases;

import com.inventory.domain.ProductRepository;

public class DeleteProductUseCase {
    private final ProductRepository repo;

    public DeleteProductUseCase(ProductRepository repo) { this.repo = repo; }

    public boolean execute(String id) {
        return repo.delete(id);
    }
}
