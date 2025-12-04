package com.example.doan.service.product;

import com.example.doan.models.Product;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

    Product findById(int id);

    Product save(Product category);

    void deleteById(int id);

    Product update(Product product);

}
