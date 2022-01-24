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

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.myapp.onetomay.login.CustomUserDetailsService;
import net.myapp.onetomay.login.User;
import net.myapp.onetomay.login.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CorrectUsername {

    @Autowired
    UserRepository repo;

    void dataCorrectness () {
        User user = new User(1, "email", "wiktor", "porowski");
        user.setPassword("123");

        CustomUserDetailsService customUserDetailsService = new CustomUserDetailsService();
        repo.save(user); // added to database
        customUserDetailsService.userRepo = repo;

        CustomUserDetails userFounded = (CustomUserDetails) customUserDetailsService.loadUserByUsername("email"); // tested method
    }
        @Given("a user with username {string},name {string},surname {string} and password {string}")
    public void a_user_with_username_name_surname_and_password(String string, String string2, String string3, String string4) {
        dataCorrectness();

       //throw new io.cucumber.java.PendingException();
    }
    @When("search for user with {string}")
    public void search_for_user_with(String string) {
        // Write code here that turns the phrase above into concrete actions
      //  throw new io.cucumber.java.PendingException();
    }
    @Then("a founded user have username {string},name {string},surname {string} and password {string}")
    public void a_founded_user_have_username_name_surname_and_password(String string, String string2, String string3, String string4) {
        // Write code here that turns the phrase above into concrete actions
     //   throw new io.cucumber.java.PendingException();
    }

}
