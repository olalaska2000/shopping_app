package net.myapp.onetomay;
import net.myapp.onetomay.login.CustomUserDetailsService;
import net.myapp.onetomay.login.User;
import net.myapp.onetomay.product.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.mockito.Mockito;

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
    public void testAddDetailToProduct(){
        Product product = new Product();

        assertEquals(0,product.getDetails().size());

        product.addDetail("jeans", "34");

        assertEquals(1,product.getDetails().size());

        assertNotEquals(2,product.getDetails().size());
    }
}
