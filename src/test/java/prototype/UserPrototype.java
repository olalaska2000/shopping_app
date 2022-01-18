package prototype;

import net.myapp.onetomay.login.User;

public class UserPrototype {
    public static User aUser(){
        User u =new User();
        u.setEmail("izabella.juwa@gmail.com");
        u.setFirstName("Izabella");
        u.setLastName("Juwa");
        u.setPassword("ania1234");
        return u;
    }


}

