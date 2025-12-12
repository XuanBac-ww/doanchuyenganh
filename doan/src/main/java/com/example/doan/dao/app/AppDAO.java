package com.example.doan.dao.app;


import com.example.doan.models.Category;

public interface AppDAO {
    void save(Category category);
    Category findCategoryById(int id);
    void deleteCategoryById(int id);
}
