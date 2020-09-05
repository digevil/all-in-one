package org.digevil.allinone.service.user;

import lombok.extern.slf4j.Slf4j;
import org.digevil.allinone.service.user.model.User;
import org.digevil.allinone.service.user.repo.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class UserServiceApplicationTests {

    @Autowired
    protected UserRepository userRepository;

    @Test
    void testCount() {
        assertEquals(3, this.userRepository.count());
    }

    @Test
    void testExample() {
        User user = new User();
        user.setName("toni");
        Optional<User> result = this.userRepository.findOne(Example.of(user));
        assertTrue(result.isPresent());
        assertEquals("toni", result.get().getName());
        assertEquals("5e00c197-eab3-11ea-ae6a-0242ac110003", result.get().getUuid());
    }

}
