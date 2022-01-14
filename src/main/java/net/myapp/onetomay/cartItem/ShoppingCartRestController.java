package net.myapp.onetomay.cartItem;


import net.myapp.onetomay.login.User;
import net.myapp.onetomay.login.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingCartRestController {

    @Autowired
    private ShoppingCartServices cartServices;

    @Autowired
    private UserService userService;

    @PostMapping("/cart/add/{pid}/{qty}")
    public String addProductToCart(@PathVariable("pid") Integer productId,
                                   @PathVariable("qty") Integer quantity,
                                   @AuthenticationPrincipal Authentication authentication){
        System.out.println("add to cart: " + productId + " - " + quantity);

        if(authentication == null || authentication instanceof AnonymousAuthenticationToken){
            return "You must login to add this product to your shopping cart.";
        }
        User user =  userService.getCurrentlyLoggedUser(authentication);

        if(user ==null){
            return "You must login to add this product to your shopping cart.";
        }
        Integer addedQuantity = cartServices.addProduct(productId,quantity,user);
        System.out.println("Item added");
        return addedQuantity + "item(s) to this product were added";
    }

    @PostMapping("/cart/update/{pid}/{qty}")
    public String updateQuantity(@PathVariable("pid") Integer productId,
                                   @PathVariable("qty") Integer quantity,
                                   @AuthenticationPrincipal Authentication authentication){
        System.out.println("add to cart: " + productId + " - " + quantity);

        if(authentication == null || authentication instanceof AnonymousAuthenticationToken){
            return "You must login to add this product to your shopping cart.";
        }
        User user =  userService.getCurrentlyLoggedUser(authentication);

        if(user ==null){
            return "You must login to add this product to your shopping cart.";
        }
        float subtotal = cartServices.updateQuantity(productId,quantity,user);

        return String.valueOf(subtotal);
    }




}
