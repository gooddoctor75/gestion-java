package com.inventory.domain;

import java.util.Objects;

public final class Product {
    private final String id;
    private String name;
    private double price;
    private int stock;

    public Product(String id, String name, double price, int stock) {
        if (id == null || id.trim().isEmpty()) throw new IllegalArgumentException("id is required");
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("name is required");
        if (price < 0) throw new IllegalArgumentException("price must be >= 0");
        if (stock < 0) throw new IllegalArgumentException("stock must be >= 0");
        this.id = id.trim();
        this.name = name.trim();
        this.price = price;
        this.stock = stock;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("name is required");
        this.name = name.trim();
    }
    public double getPrice() { return price; }
    public void setPrice(double price) {
        if (price < 0) throw new IllegalArgumentException("price must be >= 0");
        this.price = price;
    }
    public int getStock() { return stock; }
    public void setStock(int stock) {
        if (stock < 0) throw new IllegalArgumentException("stock must be >= 0");
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product p = (Product) o;
        return id.equals(p.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return String.format("%s | %s | $%.2f | stock: %d", id, name, price, stock);
    }
}
