package com.example.doan.dao.category;

import com.example.doan.models.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

    private final EntityManager entityManager;

    @Autowired
    public CategoryDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Category> findAll() {
        TypedQuery<Category> categoryTypedQuery = entityManager.createQuery("from Category",Category.class);
        return categoryTypedQuery.getResultList();
    }

    @Override
    public Category findById(int id) {
        return entityManager.find(Category.class,id);
    }

    @Override
    @Transactional
    public Category save(Category category) {
        entityManager.persist(category);
        return category;
    }

    @Override
    @Transactional
    public Category update(Category category) {
        return entityManager.merge(category);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        entityManager.remove(entityManager.find(Category.class, id));
    }
}
