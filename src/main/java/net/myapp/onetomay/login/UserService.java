package net.myapp.onetomay.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User getCurrentlyLoggedUser(Authentication authentication) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth == null) return null;
        User user = null;
        Object principal = auth.getPrincipal();

        if (principal instanceof CustomUserDetails) {
            user = ((CustomUserDetails)principal).getUser();
        }
        return user;
    }

}
