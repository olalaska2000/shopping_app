package net.myapp.onetomay.color;


import net.myapp.onetomay.category.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ColourController {

    @Autowired
    ColourRepository repo;

    @GetMapping("/colours/new")
    public String showColourNewModel(Model model){
        model.addAttribute("colour",new Colour());
        return "create_colour";
    }

    @GetMapping("/colours")
    public String viewCategoryList(Model model){
        List<Colour> colourList = repo.findAll();
        model.addAttribute("listColours", colourList);
        return "colours";
    }


    @PostMapping("/colours/save")
    public String saveColour(Colour colour){
        repo.save(colour);
        return "redirect:/colours";
    }


}
