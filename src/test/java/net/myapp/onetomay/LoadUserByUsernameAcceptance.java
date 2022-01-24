package net.myapp.onetomay;

import net.myapp.onetomay.cartItem.CartItem;
import net.myapp.onetomay.cartItem.CartItemRepository;
import net.myapp.onetomay.login.CustomUserDetails;
import net.myapp.onetomay.login.CustomUserDetailsService;
import net.myapp.onetomay.login.User;
import net.myapp.onetomay.login.UserRepository;
import net.myapp.onetomay.product.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class LoadUserByUsernameAcceptance {

    @Autowired
    UserRepository repo;

    @Test
    void dataCorrectness () {
        User user = new User(1,"email","wiktor","porowski");
        user.setPassword("123");

        CustomUserDetailsService customUserDetailsService = new CustomUserDetailsService();
        repo.save(user); // added to database
        customUserDetailsService.userRepo = repo;

        CustomUserDetails userFounded = (CustomUserDetails) customUserDetailsService.loadUserByUsername("email"); // tested method

        assertEquals("email",userFounded.getUser().getEmail());
        assertEquals("wiktor",userFounded.getUser().getFirstName());
        assertEquals("porowski",userFounded.getUser().getLastName());
        assertEquals("123",userFounded.getUser().getPassword());
    }
}
