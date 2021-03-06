package net.myapp.onetomay;

import net.myapp.onetomay.login.User;
import net.myapp.onetomay.login.UserRepository;
import net.myapp.onetomay.roles.Role;
import net.myapp.onetomay.roles.RoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //?
@Rollback(false)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private TestEntityManager entityManager;
    @Test
    public void testCreateUser(){
        User user = new User();
        user.setEmail("ania@wp.pl");
        user.setFirstName("Ania");
        user.setLastName("Nowak");
        user.setPassword("ania1234");

        User savedUser = userRepo.save(user);

        User existUser = entityManager.find(User.class,savedUser.getId());

        assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
    }

    @Test
    public void findUserByEmail(){
        String email = "olalaska00@gmail.com";
        User user = userRepo.findByEmail(email);
        assertThat(user).isNotNull();
    }

    @Test
    public void addNewRoleToUser(){
        User user = new User(99,"ann@wp.pl","Ann","Kowalska");
        user.setPassword("onpm2012");

        Role roleUser = roleRepo.findRoleByName("User");

        user.addRole(roleUser);

        User savedUser = userRepo.save(user);
        assertThat(savedUser.getRoles().size()).isEqualTo(1);

    }

    @Test
    public void testAddRolesToExistingUser(){
        User user = userRepo.findById(1 ).get();

        Role role = roleRepo.findRoleByName("User");
        Role roleAdmin = roleRepo.findRoleByName("Admin");

        user.addRole(role);
        user.addRole(roleAdmin);

        User savedUser = userRepo.save(user);

        assertThat(savedUser.getRoles().size()).isEqualTo(2);
    }

}
