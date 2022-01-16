package net.myapp.onetomay.product;

import net.myapp.onetomay.category.Category;
import net.myapp.onetomay.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    ProductRepository productRepo;

    @Autowired
    CategoryRepository categoryRepo;

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public String viewProductList(Model model){
        List<Product> productsList=  productRepo.findAll();
        model.addAttribute("productList",productsList);
        return "products";
    }

    @GetMapping("/products/new")
    public String createProductForm(Model model) {
        List<Category> categoryList =  categoryRepo.findAll();

        model.addAttribute("product", new Product());
        model.addAttribute("categoryList",categoryList);
        return "create_product";
    }

    @PostMapping("/products/save")
    public String saveProduct(@RequestParam("file") MultipartFile file, Product product, HttpServletRequest request) throws IOException {
        String [] detailIds =  request.getParameterValues("detailId");
       String [] detailNames =  request.getParameterValues("detailName");
       String [] detailValues = request.getParameterValues("detailValue");

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        if(fileName.contains(".."))
        {
            System.out.println("not a a valid file");
        }
        try {
            product.setPhoto(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }

       for(int i = 0; i < detailNames.length ; i++){

           if(detailIds!=null && detailIds.length>0){
               product.setDetail(Integer.valueOf(detailIds[i]),detailNames[i], detailValues[i]);


           }else{

               product.addDetail(detailNames[i],detailValues[i]);
           }

       }

        //productService.saveProductToDb(file, product.getName(),product.getPrice(), product.getCategory());

       productRepo.save(product);
        return "redirect:/products";
    }

    @GetMapping("/products/edit/{id}")
    public String editProduct(@PathVariable("id") Integer id, Model model){
        Product updatedProduct = productRepo.findById(id).get();
        model.addAttribute("product", updatedProduct);

        List<Category> categoryList =  categoryRepo.findAll();
        model.addAttribute("categoryList",categoryList);


        return "create_product";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteMapping(@PathVariable("id") Integer id, Model model){
        productRepo.deleteById(id);

        return "redirect:/products";
    }

    @GetMapping("/products/{id}")
    public String viewProductDetails(@PathVariable("id") Integer id, Model model){
        Product chosenProduct = productRepo.findById(id).get();
        model.addAttribute("product",chosenProduct);
        return "product_detail";
    }

    @GetMapping("/403")
    public String error403(){
        return "403";
    }


}
