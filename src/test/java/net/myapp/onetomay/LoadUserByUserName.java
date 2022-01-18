package net.myapp.onetomay;

import net.myapp.onetomay.login.CustomUserDetailsService;
import net.myapp.onetomay.login.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LoadUserByUserName {

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
}
