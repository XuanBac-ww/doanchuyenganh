package com.example.doan.controller.shop;

import com.example.doan.models.Footer;
import com.example.doan.service.footer.IFooterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@ControllerAdvice
public class FooterShopController {

    private final IFooterService footerService;

    @Autowired
    public FooterShopController(IFooterService footerService) {
        this.footerService = footerService;
    }

    @ModelAttribute("commonFooter")
    public Footer getFooterData() {
        List<Footer> footers = footerService.findAll();
        return footers.isEmpty() ? new Footer() : footers.get(0);
    }
}
