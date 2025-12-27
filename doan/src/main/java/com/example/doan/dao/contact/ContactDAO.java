package com.example.doan.dao.contact;

import com.example.doan.models.Category;
import com.example.doan.models.Contact;

import java.util.List;

public interface ContactDAO {
    List<Contact> findAll();
    Contact findById(int id);
    Contact save(Contact contact);
    void deleteById(int id);
    Contact update(Contact contact);
}
