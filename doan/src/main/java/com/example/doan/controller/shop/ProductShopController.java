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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("")
public class ProductShopController {

    private final IProductService productService;
    private final ICategoryService categoryService;

    @Autowired
    public ProductShopController(IProductService productService, ICategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/our-store")
    public String ourStore(Model model,
                           @RequestParam(name = "categoryId", required = false, defaultValue = "0") int categoryId) {

        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);

        List<Product> products;
        if (categoryId > 0) {
            products = productService.findByCategoryId(categoryId);
        } else {
            products = productService.findAll();
        }
        model.addAttribute("products", products);
        return "home/our-store";
    }

    @GetMapping("/product-detail/{id}")
    public String viewProductDetail(@PathVariable("id") Integer id, Model model) {
        Product product = productService.findById(id);

        model.addAttribute("product", product);
        return "home/product-detail";
    }



}
