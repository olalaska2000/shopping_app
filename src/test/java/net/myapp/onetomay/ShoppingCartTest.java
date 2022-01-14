package net.myapp.onetomay;

import net.myapp.onetomay.cartItem.CartItem;
import net.myapp.onetomay.cartItem.CartItemRepository;
import net.myapp.onetomay.customer.Customer;
import net.myapp.onetomay.login.User;
import net.myapp.onetomay.login.UserService;
import net.myapp.onetomay.product.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.test.annotation.Rollback;
import org.springframework.ui.Model;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class ShoppingCartTest {

    @Autowired
    private CartItemRepository cartRepo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testAddCartItem(){
        Product product = entityManager.find(Product.class, 35);
        User user = entityManager.find(User.class, 1);

        CartItem newItem = new CartItem();
        newItem.setUser(user);
        newItem.setProduct(product);
        newItem.setQuantity(5);

        CartItem savedCartItem = cartRepo.save(newItem);
        assertTrue(savedCartItem.getId()>0);
    }


    @Test
    public void testGetCartByCustomer(){
        User user = new User();
        user.setId(1);

        List<CartItem> cartItems = cartRepo.findByUser(user);
        assertEquals(2,cartItems.size());
    }



}
