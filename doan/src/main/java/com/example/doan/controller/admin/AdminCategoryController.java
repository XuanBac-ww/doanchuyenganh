package com.example.doan.controller.admin;

import com.example.doan.models.Category;
import com.example.doan.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/category")
public class AdminCategoryController {

    private final ICategoryService categoryService;

    @Autowired
    public AdminCategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // hien thi tat ca category
    @GetMapping("/all")
    public String findAll(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);

        model.addAttribute("category", new Category());
        return "admin/category/category";
    }


    // submit form them moi category
    @PostMapping("/save")
    public String saveCategory(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        return "redirect:/admin/category/all";
    }

    // lay form update
    @GetMapping("/update")
    public String showFormUpdate(@RequestParam("id") int id, Model model) {
        Category category = categoryService.findById(id);  // lay object cũ
        model.addAttribute("category", category);

        model.addAttribute("categories", categoryService.findAll());   // load lai danh sach

        return "admin/category/category";
    }
    //submit form update
    @PostMapping("/update")
    public String updateCategory(@ModelAttribute("category") Category category) {
        categoryService.update(category);
        return "redirect:/admin/category/all";
    }


    @PostMapping("/delete")
    public String deleteCategory(@RequestParam("id") int id) {
        categoryService.deleteById(id);
        return "redirect:/admin/category/all";
    }
}
