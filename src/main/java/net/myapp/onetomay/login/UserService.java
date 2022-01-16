package net.myapp.onetomay.login;

import net.myapp.onetomay.roles.Role;
import net.myapp.onetomay.roles.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepo;

    @Autowired
    RoleRepository roleRepo;

    public void saveUserWithDefaultRole(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        Role role = roleRepo.findRoleByName("User");
        user.addRole(role);
        userRepo.save(user);

    }

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

    public List<User> listAll() {
        return userRepo.findAll();
    }
}
