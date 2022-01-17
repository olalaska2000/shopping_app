package prototype;

import net.myapp.onetomay.login.User;

public class UserPrototype {
    public static User aUser(){
        User u =new User();
        u.setEmail("test_name");
        return u;
    }
}
