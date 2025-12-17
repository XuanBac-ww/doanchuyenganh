package com.example.doan.controller.shop;

import com.example.doan.models.Product;
import com.example.doan.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
public class ProductShopController {

    private final IProductService productService;

    @Autowired
    public ProductShopController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/our-store")
    public String findAll(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products",products);
        return "home/our-store";
    }

    @GetMapping("/product-detail/{id}")
    public String viewProductDetail(@PathVariable("id") Integer id, Model model) {
        Product product = productService.findById(id);

        model.addAttribute("product", product);
        return "home/product-detail";
    }



}
