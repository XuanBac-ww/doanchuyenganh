package com.example.doan.dao.product;

import com.example.doan.models.Product;

import java.util.List;

public interface ProductDAO {

    List<Product> findAll();
    Product findById(int id);
    Product save(Product product);
    void deleteById(int id);
    Product update(Product product);

    List<Product> findByCategoryId(int categoryId);
}
