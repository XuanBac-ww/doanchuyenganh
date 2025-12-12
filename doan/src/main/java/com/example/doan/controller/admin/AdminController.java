package com.example.doan.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin/cart")
    public String cart() {
        return "/admin/cart/cart";
    }
    @GetMapping("/admin/articles")
    public String article() {
        return "/admin/articles/articles";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin";
    }

}
