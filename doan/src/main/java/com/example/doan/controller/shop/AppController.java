package com.example.doan.controller.shop;

import com.example.doan.models.Product;
import com.example.doan.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AppController {

    private final IProductService productService;

    @Autowired
    public AppController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Product> listProducts = productService.findAll();
        model.addAttribute("products", listProducts);
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

    @GetMapping("/cart")
    public String cartPage() {
        return "login";
    }

}
