package com.example.doan.controller.admin;

import com.example.doan.models.Footer;
import com.example.doan.service.footer.IFooterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/footer")
public class AdminFooterController {
    private final IFooterService footerService;

    public AdminFooterController(IFooterService footerService) {
        this.footerService = footerService;
    }

    @GetMapping("")
    public String footerPage(Model model) {
        List<Footer> footers = footerService.findAll();
        model.addAttribute("footers", footers);
        model.addAttribute("footer", new Footer());
        return "admin/footer/footer";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("footer") Footer footer) {
        if (footer.getId() != null && footer.getId() > 0) {
            footerService.update(footer);
        }
        else {
            footerService.save(footer);
        }
        return "redirect:/admin/footer";
    }

    @PostMapping("/delete")
    public String deleteFooter(@RequestParam("id") int id) {
        footerService.deleteById(id);
        return "redirect:/admin/footer";
    }

}
