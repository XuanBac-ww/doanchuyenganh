package com.example.doan.service.footer;

import com.example.doan.models.Footer;

import java.util.List;

public interface IFooterService {
    List<Footer> findAll();
    Footer save(Footer footer);
    void deleteById(int id);
    Footer update(Footer footer);
}
