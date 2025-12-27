package com.example.doan.dao.footer;

import com.example.doan.models.Footer;

import java.util.List;

public interface FooterDAO {
    List<Footer> findAll();
    Footer save(Footer footer);
    void deleteById(int id);
    Footer update(Footer footer);
}
