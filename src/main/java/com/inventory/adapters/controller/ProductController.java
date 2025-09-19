package com.inventory.adapters.controller;

import com.inventory.domain.Product;
import com.inventory.usecases.AddProductUseCase;
import com.inventory.usecases.DeleteProductUseCase;
import com.inventory.usecases.ListAllProductsUseCase;
import com.inventory.usecases.UpdateProductUseCase;

import java.util.List;

public class ProductController {
    private final AddProductUseCase addUC;
    private final UpdateProductUseCase updateUC;
    private final DeleteProductUseCase deleteUC;
    private final ListAllProductsUseCase listUC;

    public ProductController(AddProductUseCase addUC, UpdateProductUseCase updateUC,
                             DeleteProductUseCase deleteUC, ListAllProductsUseCase listUC) {
        this.addUC = addUC;
        this.updateUC = updateUC;
        this.deleteUC = deleteUC;
        this.listUC = listUC;
    }

    public boolean addProduct(Product p) { return addUC.execute(p); }
    public boolean updateProduct(Product p) { return updateUC.execute(p); }
    public boolean deleteProduct(String id) { return deleteUC.execute(id); }
    public List<Product> listProducts() { return listUC.execute(); }
}
