package com.example.doan.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String image;

    private int status = 0;

    @OneToMany(mappedBy = "category",cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    private List<Product> products;

    public Category(List<Product> products) {
        this.products = products;
    }

    public Category(Integer id, String name, String image, int status, List<Product> products) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.status = status;
        this.products = products;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Category(String name, String image, int status) {
        this.name = name;
        this.image = image;
        this.status = status;
    }

    public Category() {
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", status=" + status +
                '}';
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void add(Product tempProduct) {
        if(products ==null) {
            products = new ArrayList<>();
        }
        products.add(tempProduct);
        tempProduct.setCategory(this);
    }
}
