package com.zrs.concurrent;

public final class Product {
    private String name;
    
    public Product() {
        super();
    }

    public Product(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product [name=" + name + "]";
    }
    
}