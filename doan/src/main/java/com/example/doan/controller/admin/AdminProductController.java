package com.example.doan.controller.admin;

import com.example.doan.models.Category;
import com.example.doan.models.Product;
import com.example.doan.service.category.ICategoryService;
import com.example.doan.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/product")
public class AdminProductController {

    private final IProductService productService;
    private final ICategoryService categoryService;

    @Autowired
    public AdminProductController(IProductService productService, ICategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    public String findAll(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);

        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        Product newProduct = new Product();
        newProduct.setCategory(new Category());
        model.addAttribute("product", newProduct);

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
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.findAll());

        model.addAttribute("products", productService.findAll());
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
