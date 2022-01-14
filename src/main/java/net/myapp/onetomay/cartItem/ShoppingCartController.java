package net.myapp.onetomay.cartItem;


import net.myapp.onetomay.category.Category;
import net.myapp.onetomay.login.CustomUserDetailsService;
import net.myapp.onetomay.login.User;
import net.myapp.onetomay.login.UserService;
import net.myapp.onetomay.product.Product;
import net.myapp.onetomay.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ShoppingCartController {

    @Autowired
    private ShoppingCartServices cartServices;

    @Autowired
    private CartItemRepository cartRepo;

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private UserService userService;

    @GetMapping("/cart")
    public String showShoppingCart(Model model, @AuthenticationPrincipal Authentication authentication){

        User user =  userService.getCurrentlyLoggedUser(authentication);
        List<CartItem> cartItems = cartServices.listCartItems(user);

        model.addAttribute("cartItems", cartItems);
        model.addAttribute("pageTitle", "Shopping Cart");
        return "shopping_cart";
    }

    @GetMapping("/cart/{id}")
    public String addProduct(@PathVariable("id") Integer id, Model model,  @AuthenticationPrincipal Authentication authentication){
        User user =  userService.getCurrentlyLoggedUser(authentication);
        Product chosenProduct = productRepo.findById(id).get();
        List<CartItem> cartItems = cartServices.listCartItems(user);

        cartItems.add(new CartItem(chosenProduct,user,1));
        cartRepo.save(new CartItem(chosenProduct,user,1));
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("pageTitle", "Shopping Cart");
        return "shopping_cart";
    }
}
