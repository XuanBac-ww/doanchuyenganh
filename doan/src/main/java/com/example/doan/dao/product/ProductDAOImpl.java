package com.example.doan.dao.product;

import com.example.doan.models.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {

    private final EntityManager entityManager;

    @Autowired
    public ProductDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Product> findAll() {
        TypedQuery<Product> productTypedQuery = entityManager.createQuery("from Product",Product.class);
        return productTypedQuery.getResultList();
    }

    @Override
    public Product findById(int id) {
        return entityManager.find(Product.class,id);
    }

    @Override
    @Transactional
    public Product save(Product product) {
        entityManager.persist(product);
        return product;
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        entityManager.remove(entityManager.find(Product.class, id));
    }

    @Override
    @Transactional
    public Product update(Product product) {
        return entityManager.merge(product);
    }

    @Override
    public List<Product> findByCategoryId(int categoryId) {
        String jpql = "FROM Product p WHERE p.category.id = :theCategoryId";

        TypedQuery<Product> query = entityManager.createQuery(jpql, Product.class);
        query.setParameter("theCategoryId", categoryId);

        return query.getResultList();
    }
}
