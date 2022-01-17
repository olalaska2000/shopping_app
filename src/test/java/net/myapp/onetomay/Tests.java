package net.myapp.onetomay;

import net.myapp.onetomay.brand.BrandRepository;
import net.myapp.onetomay.cartItem.CartItemRepository;
import net.myapp.onetomay.category.Category;
import net.myapp.onetomay.login.CustomUserDetailsService; //!
import net.myapp.onetomay.color.ColourRepository;
import net.myapp.onetomay.login.User;
import net.myapp.onetomay.login.UserRepository;
import net.myapp.onetomay.category.CategoryRepository;
import net.myapp.onetomay.product.Product;
import net.myapp.onetomay.product.ProductRepository;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.mockito.Mockito;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public class Tests {

    @Test
    public void testLoadUserByUserName() {
        User user = new User();
        user.setEmail("Wiktor");
        user.setPassword("123");

        User user2 = new User();
        user2.setEmail("Tor");
        user2.setPassword("456");

        CustomUserDetailsService cus = new CustomUserDetailsService();
        CustomUserDetailsService cusSpy = Mockito.spy(cus);

        Mockito.doReturn(user).when(cusSpy).findUser("Wiktor");
        assertEquals("123", cusSpy.loadUserByUsername("Wiktor").getPassword());

        Mockito.doReturn(user2).when(cusSpy).findUser("Wiktor");
        assertNotEquals("123", cusSpy.loadUserByUsername("Wiktor").getPassword());
    }

    @Test
    public void testAddDetailtoProduct(){
        Product product = new Product();

        assertEquals(0,product.getDetails().size());

        product.addDetail("jeans", "34");

        assertEquals(1,product.getDetails().size());

        assertNotEquals(2,product.getDetails().size());
    }
}
