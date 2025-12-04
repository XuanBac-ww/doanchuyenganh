package com.example.doan.dao.category;

import com.example.doan.models.Category;

import java.util.List;

public interface CategoryDAO {
    List<Category> findAll();

    Category findById(int id);

    Category save(Category category);

    Category update(Category category);

    void deleteById(int id);

}
