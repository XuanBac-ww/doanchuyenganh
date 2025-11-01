package com.example.doan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/about")
    public String showAboutPage() {
        return "/about";
    }

    @GetMapping("/blog")
    public String showBlogPage() {
        return "/blog";
    }

    @GetMapping("/our-store")
    public String showProductPage() {
        return "/our-store";
    }

    @GetMapping("/contact")
    public String showContactPage() {
        return "/contact";
    }

    @GetMapping("/thankyou")
    public String showThankyouPage() {
        return "/thankyou";
    }
}
