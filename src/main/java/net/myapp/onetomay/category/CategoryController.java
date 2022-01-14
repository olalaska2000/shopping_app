package net.myapp.onetomay.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    CategoryRepository repo;

    @GetMapping("/categories")
    public String viewCategoryList(Model model){
        List<Category> categoryList = repo.findAll();
        model.addAttribute("listCategories", categoryList);
        return "categories";
    }

    @GetMapping("/categories/new")
    public String showCategoryNewModel(Model model){
        model.addAttribute("category",new Category());
        return "create_category";
    }

    @PostMapping("/categories/save")
    public String saveCategory(Category category){
        repo.save(category);
        return "redirect:/categories";
    }

}
