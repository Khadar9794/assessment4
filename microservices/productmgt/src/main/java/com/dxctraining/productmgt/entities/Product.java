package com.dxctraining.productmgt.entities;

import org.springframework.data.annotation.Id;


import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document("products")
public class Product {

    @Id
    private String id;

    private String name;

    public Product(){

    }

    public Product(String name){
        this.name=name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
