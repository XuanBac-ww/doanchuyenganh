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
        return "home/about";
    }

    @GetMapping("/blog")
    public String showBlogPage() {
        return "home/blog";
    }

    @GetMapping("/our-store")
    public String showProductPage() {
        return "home/our-store";
    }

    @GetMapping("/contact")
    public String showContactPage() {
        return "home/contact";
    }

    @GetMapping("/thankyou")
    public String showThankyouPage() {
        return "home/thankyou";
    }


    @GetMapping("/admin")
    public String adminPage() {
        return "admin";
    }
}
