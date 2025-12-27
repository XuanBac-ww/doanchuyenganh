package com.example.doan.controller.shop;

import com.example.doan.models.Contact;
import com.example.doan.service.contact.IContactService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class ContactShopController {

    private final IContactService contactService;

    @Autowired
    public ContactShopController(IContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/contact")
    public String showContactPage(Model model, HttpServletRequest request) {
        request.getSession();
        model.addAttribute("contact", new Contact());
        return "home/contact";
    }

    @PostMapping("/save")
    public String saveContact(@ModelAttribute("contact") Contact contact) {
        contactService.save(contact);

        return "redirect:/thankyou";
    }

    @GetMapping("/thankyou")
    public String showThankYou() {
        return "home/thankyou";
    }


}
