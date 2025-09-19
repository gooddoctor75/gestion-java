package com.inventory.cli;

import com.inventory.adapters.controller.ProductController;
import com.inventory.adapters.persistence.ProductRepositoryImpl;
import com.inventory.domain.Product;
import com.inventory.usecases.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var repo = new ProductRepositoryImpl();
        var addUC = new AddProductUseCase(repo);
        var updateUC = new UpdateProductUseCase(repo);
        var deleteUC = new DeleteProductUseCase(repo);
        var listUC = new ListAllProductsUseCase(repo);
        var ctrl = new ProductController(addUC, updateUC, deleteUC, listUC);

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n== Inventory CLI ==");
            System.out.println("1) Add product");
            System.out.println("2) Update product");
            System.out.println("3) Delete product");
            System.out.println("4) List products");
            System.out.println("5) Exit");
            System.out.print("Option: ");
            String opt = sc.nextLine().trim();
            try {
                switch (opt) {
                    case "1" -> {
                        System.out.print("id: "); String id = sc.nextLine().trim();
                        System.out.print("name: "); String name = sc.nextLine().trim();
                        System.out.print("price: "); double price = Double.parseDouble(sc.nextLine().trim());
                        System.out.print("stock: "); int stock = Integer.parseInt(sc.nextLine().trim());
                        Product p = new Product(id, name, price, stock);
                        System.out.println(ctrl.addProduct(p) ? "Added" : "Product already exists");
                    }
                    case "2" -> {
                        System.out.print("id (to update): "); String id = sc.nextLine().trim();
                        Product existing = repo.findById(id);
                        if (existing == null) { System.out.println("Not found"); break; }
                        System.out.print("new name ("+existing.getName()+"): "); String name = sc.nextLine().trim();
                        System.out.print("new price ("+existing.getPrice()+"): "); String priceS = sc.nextLine().trim();
                        System.out.print("new stock ("+existing.getStock()+"): "); String stockS = sc.nextLine().trim();
                        if (!name.isEmpty()) existing.setName(name);
                        if (!priceS.isEmpty()) existing.setPrice(Double.parseDouble(priceS));
                        if (!stockS.isEmpty()) existing.setStock(Integer.parseInt(stockS));
                        System.out.println(ctrl.updateProduct(existing) ? "Updated" : "Update failed");
                    }
                    case "3" -> {
                        System.out.print("id (to delete): "); String id = sc.nextLine().trim();
                        System.out.println(ctrl.deleteProduct(id) ? "Deleted" : "Not found");
                    }
                    case "4" -> {
                        List<Product> all = ctrl.listProducts();
                        if (all.isEmpty()) System.out.println("No products");
                        else all.forEach(p -> System.out.println(p));
                    }
                    case "5" -> { System.out.println("Bye"); sc.close(); return; }
                    default -> System.out.println("Invalid option");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number input. Try again.");
            } catch (IllegalArgumentException ex) {
                System.out.println("Validation error: " + ex.getMessage());
            } catch (Exception ex) {
                System.out.println("Unexpected error: " + ex.getMessage());
            }
        }
    }
}
