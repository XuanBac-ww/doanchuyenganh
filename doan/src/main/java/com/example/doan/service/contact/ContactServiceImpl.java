package com.example.doan.service.contact;

import com.example.doan.dao.contact.ContactDAO;
import com.example.doan.models.Contact;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements IContactService {

    private final ContactDAO contactDAO;

    public ContactServiceImpl(ContactDAO contactDAO) {
        this.contactDAO = contactDAO;
    }

    @Override
    public List<Contact> findAll() {
        return contactDAO.findAll();
    }

    @Override
    public Contact findById(int id) {
        return contactDAO.findById(id);
    }

    @Override
    public Contact save(Contact contact) {
        return contactDAO.save(contact);
    }

    @Override
    public void deleteById(int id) {
        contactDAO.deleteById(id);
    }

    @Override
    public Contact update(Contact contact) {
        return contactDAO.update(contact);
    }
}
