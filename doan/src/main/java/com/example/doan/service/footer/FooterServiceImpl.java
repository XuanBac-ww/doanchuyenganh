package com.example.doan.service.footer;

import com.example.doan.dao.footer.FooterDAO;
import com.example.doan.models.Footer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FooterServiceImpl implements IFooterService {
    private final FooterDAO footerDAO;


    public FooterServiceImpl(FooterDAO footerDAO) {
        this.footerDAO = footerDAO;
    }

    @Override
    public List<Footer> findAll() {
        return footerDAO.findAll();
    }

    @Override
    public Footer save(Footer footer) {
        return footerDAO.save(footer);
    }

    @Override
    public void deleteById(int id) {
        footerDAO.deleteById(id);
    }

    @Override
    public Footer update(Footer footer) {
        return footerDAO.update(footer);
    }
}
