package org.digevil.allinone.classic.web;

import org.digevil.allinone.core.model.Hello;
import org.digevil.allinone.core.model.User;
import org.digevil.allinone.classic.service.IUserService;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api")
public class ApiController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private IUserService userService;

    @GetMapping("/hello")
    public Hello hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Hello(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/user/all")
    public List<User> findAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/user/{id}")
    public User findUserById(@PathVariable UUID id) {
        return userService.findById(id);
    }

    @PostMapping("/user")
    public Map insertUser(@RequestBody User user) {
        return ImmutableMap.of("id", userService.insert(user).toString());
    }

    @PutMapping("/user/{id}")
    public void updateUser(@RequestBody User user, @PathVariable UUID id) {
        user.setId(id);
        userService.update(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUserById(@PathVariable UUID id) {
        userService.delete(id);
    }
}
