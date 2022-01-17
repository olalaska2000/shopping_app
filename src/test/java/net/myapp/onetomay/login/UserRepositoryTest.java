package net.myapp.onetomay.login;

import jdk.dynalink.linker.support.Guards;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


import static org.assertj.core.api.Assertions.assertThat;



import static org.junit.jupiter.api.Assertions.*;
import static prototype.UserPrototype.aUser;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    @Test
    void findByEmail() {
        userRepository.save(aUser());
        User foundUser =userRepository.findByEmail(aUser().getEmail());
        assertThat(foundUser).isNotNull();
        assertThat(aUser().getEmail()).isEqualTo(foundUser.getEmail());

    }


}