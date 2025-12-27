package com.example.doan.service.contact;

import com.example.doan.models.Contact;

import java.util.List;

public interface IContactService {
    List<Contact> findAll();
    Contact findById(int id);
    Contact save(Contact contact);
    void deleteById(int id);
    Contact update(Contact contact);
}
