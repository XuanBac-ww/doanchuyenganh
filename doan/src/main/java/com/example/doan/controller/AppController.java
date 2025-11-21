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
    public String showContactPage()  {
        return "home/contact";
    }

    @GetMapping("/thankyou")
    public String showThankyouPage() {
        return "home/thankyou";
    }

    @GetMapping("/featured-books")
    public String showFeaturedBooksPage() {
        return "/fragments/feature-books";
    }

    @GetMapping("/popular-books")
    public String showPopularBooksPage() {
        return "/fragments/popular-books";
    }

    @GetMapping("/special-offer")
    public String showSpecialOfferBooksPage() {
        return "/fragments/special-offer";
    }

    @GetMapping("/latest-blog")
    public String showArticleBooksPage() {
        return "/fragments/latest-blog";
    }

    @GetMapping("/download-app")
    public String showDownloadAppPage() {
        return "/fragments/download-app";
    }


    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

}
