package com.example.doan.controller;

import com.example.doan.models.Product;
import com.example.doan.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/product")
public class ProductController {

    private final IProductService productService;

    @Autowired
    public ProductController(IProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/all")
    public String findAll(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products",products);

        model.addAttribute("product", new Product());
        return "admin/product/product";
    }

    // submit form them moi product
    @PostMapping("/save")
    public String saveCategory(@ModelAttribute("product") Product product) {
        productService.save(product);
        return "redirect:/admin/product/all";
    }

    @GetMapping("/update")
    public String showFormUpdate(@RequestParam("id") int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product",product);
        model.addAttribute("products",productService.findAll());
        return "admin/product/product";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute("product") Product product) {
        productService.update(product);
        return "redirect:/admin/product/all";
    }

    @PostMapping("/delete")
    public String deleteCategory(@RequestParam("id") int id) {
        productService.deleteById(id);
        return "redirect:/admin/product/all";
    }

}
