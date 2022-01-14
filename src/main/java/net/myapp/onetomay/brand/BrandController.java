package net.myapp.onetomay.brand;

import net.myapp.onetomay.category.Category;
import net.myapp.onetomay.category.CategoryRepository;
import net.myapp.onetomay.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BrandController {

    @Autowired
    BrandRepository brandRepo;

    @Autowired
    CategoryRepository categoryRepo;

    @GetMapping("/brands")
    public String viewBrands(Model model){
        List<Brand> brandList =  brandRepo.findAll();
        model.addAttribute("brandList", brandList);
        return "brands";
    }

    @GetMapping("/brands/new")
    public String newBrand(Model model){

        List<Category> categoryList = categoryRepo.findAll();

        model.addAttribute("brand",new Brand());
        model.addAttribute("categoryList", categoryList);

        return "create_brand";
    }

    @PostMapping("/brands/save")
    public String newBrand(Brand brand){
        brandRepo.save(brand);
        return "redirect:/brands";
    }

    @GetMapping("/brands/edit/{id}")
    public String editProduct(@PathVariable("id") Integer id, Model model){
        Brand updatedBrand = brandRepo.findById(id).get();
        model.addAttribute("brand", updatedBrand);

        List<Category> categoryList =  categoryRepo.findAll();
        model.addAttribute("categoryList",categoryList);
        return "create_brand";
    }

    @GetMapping("/brands/delete/{id}")
    public String deleteMapping(@PathVariable("id") Integer id, Model model){
        brandRepo.deleteById(id);

        return "redirect:/brands";
    }
}
