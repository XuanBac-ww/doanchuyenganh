package com.example.doan.controller.shop;

import com.example.doan.models.Category;
import com.example.doan.models.Product;
import com.example.doan.service.category.ICategoryService;
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
public class CategoryShopController {

    private final ICategoryService categoryService;
    private final IProductService productService;

    @Autowired
    public CategoryShopController(ICategoryService categoryService, IProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @GetMapping("/category")
    public String findAll(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "home/category";
    }

    @GetMapping("/category/{id}")
    public String productsByCategory(@PathVariable("id") int id, Model model) {
        Category category = categoryService.findById(id);

        List<Product> products = productService.findByCategoryId(id);

        model.addAttribute("category", category);
        model.addAttribute("products", products);

        return "home/product-list";
    }

}
