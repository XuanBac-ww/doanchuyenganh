package com.example.doan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {


    @GetMapping("/admin/category")
    public String category() {
        return "/admin/category/category";
    }

    @GetMapping("/admin/product")
    public String product() {
        return "/admin/product/product";
    }

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
