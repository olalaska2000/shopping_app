package net.myapp.onetomay.cartItem;

import net.myapp.onetomay.login.User;
import net.myapp.onetomay.product.Product;
import net.myapp.onetomay.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ShoppingCartServices {

    @Autowired
    private CartItemRepository cartRepo;

    @Autowired
    private ProductRepository productRepo;

    public List<CartItem> listCartItems(User user){
        return cartRepo.findByUser(user);
    }

    public Integer addProduct(Integer productId, Integer quantity, User user){
        Integer addedQuanity = quantity;
        Product addedProduct = productRepo.findById(productId).get();
        CartItem cartItem = cartRepo.findByUserAndProduct(user,addedProduct);

        if(cartItem!=null){
            addedQuanity = cartItem.getQuantity() + quantity;
            cartItem.setQuantity(addedQuanity);
        }else{
            cartItem = new CartItem();
            cartItem.setQuantity(quantity);
            cartItem.setProduct(addedProduct);
            cartItem.setUser(user);
        }
        cartRepo.save(cartItem);


        return addedQuanity;
    }


    public float updateQuantity(Integer productId, Integer quantity, User user){
        cartRepo.updateQuantity(productId,quantity,user.getId());
        Product product = productRepo.findById(productId).get();
        float subtotal = product.getPrice() * quantity;
        return subtotal;
    }
}

