package com.example.doan.controller.admin;

import com.example.doan.models.Category;
import com.example.doan.models.Contact;
import com.example.doan.service.contact.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/contact")
public class AdminContactController {

    private final IContactService contactService;

    @Autowired
    public AdminContactController(IContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/all")
    public String findAll(Model model) {
        List<Contact> contacts = contactService.findAll();
        model.addAttribute("contacts", contacts);
        model.addAttribute("contact", new Contact());
        return "admin/contact/contact";
    }




    // lay form update
    @GetMapping("/update")
    public String showFormUpdate(@RequestParam("id") int id, Model model) {
        Contact contact = contactService.findById(id);  // lay object cũ
        model.addAttribute("contact", contact);

        model.addAttribute("contacts", contactService.findAll());   // load lai danh sach

        return "admin/contact/contact";
    }
    //submit form update
    @PostMapping("/update")
    public String updateCategory(@ModelAttribute("contact") Contact contact) {
        contactService.update(contact);
        return "redirect:/admin/contact/all";
    }

    @PostMapping("/delete")
    public String deleteCategory(@RequestParam("id") int id) {
        contactService.deleteById(id);
        return "redirect:/admin/contact/all";
    }
}
