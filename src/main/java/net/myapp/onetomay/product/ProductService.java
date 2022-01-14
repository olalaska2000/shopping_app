package net.myapp.onetomay.product;

import net.myapp.onetomay.category.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;


@Service
public class ProductService {

//    @Autowired
//    private ProductRepository productRepo;
//
//    public void saveProductToDb(MultipartFile file, String name, float price, Category category) throws IOException {
//
//        Product p = new Product();
//        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//
//        if (fileName.contains(". .")){
//            System.out.println("Not a valid file");
//        }
//
//        try{
//            p.setPhoto(Base64.getEncoder().encodeToString(file.getBytes()));
//        }catch(IOException e){
//            e.printStackTrace();
//        }
//        p.setName(name);
//        p.setPrice(price);
//        p.setCategory(category);
//        productRepo.save(p);
//    }

}
