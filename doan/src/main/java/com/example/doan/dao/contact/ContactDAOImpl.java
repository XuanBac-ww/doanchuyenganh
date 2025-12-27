package com.example.doan.dao.contact;

import com.example.doan.models.Category;
import com.example.doan.models.Contact;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ContactDAOImpl implements ContactDAO {

    private final EntityManager entityManager;

    @Autowired
    public ContactDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Contact> findAll() {
        TypedQuery<Contact> contactTypedQuery = entityManager.createQuery("from Contact",Contact.class);
        return contactTypedQuery.getResultList();
    }

    @Override
    public Contact findById(int id) {
        return entityManager.find(Contact.class,id);
    }

    @Override
    @Transactional
    public Contact save(Contact contact) {
        entityManager.persist(contact);
        return contact;
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        entityManager.remove(entityManager.find(Contact.class, id));
    }

    @Override
    @Transactional
    public Contact update(Contact contact) {
        return entityManager.merge(contact);
    }

}
