package org.digevil.allinone.classic.web;

import com.google.common.collect.ImmutableMap;
import org.digevil.allinone.classic.service.IRedisService;
import org.digevil.allinone.classic.service.IUserService;
import org.digevil.allinone.core.model.Hello;
import org.digevil.allinone.core.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping(path = "/api", produces = "application/json")
@CrossOrigin(origins = "*")
public class ApiController {

    private static final String template = "Hello, %s!";
    private final AtomicLong helloCounter = new AtomicLong();

    @Autowired
    @Qualifier(value = "cachedUserService")
    private IUserService userService;

    @Autowired
    private IRedisService redisService;

    @GetMapping("/hello")
    public Hello hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Hello(helloCounter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/user/all")
    public List<User> findAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/user/all/paged")
    public Page<User> findAllUsersByPage(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        return userService.findAllPaged(PageRequest.of(pageNum, pageSize));
    }

    @PostMapping("/user/query/paged")
    public Page<User> findUsersByExampleAndPage(@RequestBody User example, @RequestParam(value = "pageNum", defaultValue = "1") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        return userService.findByExample(example, PageRequest.of(pageNum, pageSize));
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
        user.setId(id.hashCode());
        userService.update(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUserById(@PathVariable UUID id) {
        userService.delete(id);
    }

    @GetMapping("/redis/get/{key}")
    public String redisGetByKey(@PathVariable String key) {
        return redisService.get(key);
    }

    @PostMapping("/redis/set/{key}/{value}")
    public void redisSetGetByKey(@PathVariable String key, @PathVariable String value) {
        redisService.set(key, value);
    }
}
