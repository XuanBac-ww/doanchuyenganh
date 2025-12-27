package com.example.doan.dao.footer;

import com.example.doan.models.Footer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class FooterDAOImpl implements FooterDAO {

    private final EntityManager entityManager;

    @Autowired
    public FooterDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Footer> findAll() {
        TypedQuery<Footer> footerTypedQuery = entityManager.createQuery("from Footer",Footer.class);
        return footerTypedQuery.getResultList();
    }

    @Override
    @Transactional
    public Footer save(Footer footer) {
        entityManager.persist(footer);
        return footer;
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        entityManager.remove(entityManager.find(Footer.class, id));
    }

    @Override
    @Transactional
    public Footer update(Footer footer) {
        return entityManager.merge(footer);
    }
}
