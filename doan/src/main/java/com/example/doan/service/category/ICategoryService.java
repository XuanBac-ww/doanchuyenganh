package com.example.doan.service.category;

import com.example.doan.models.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    Category findById(int id);

    Category save(Category category);

    void deleteById(int id);

    Category update(Category category);
}
