package com.example.doan.dao.app;

import com.example.doan.models.Category;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDaoImpl implements AppDAO{

    private final EntityManager entityManager;

    @Autowired
    public AppDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Category category) {
        entityManager.persist(category);
    }

    @Override
    public Category findCategoryById(int id) {
        return entityManager.find(Category.class, id);
    }

    @Override
    @Transactional
    public void deleteCategoryById(int id) {
        Category tempCategory = entityManager.find(Category.class, id);
        entityManager.remove(tempCategory);
    }
}
