package org.digevil.allinone.micro.services.users.web;

import org.digevil.allinone.core.model.User;
import org.digevil.allinone.micro.services.users.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: toni
 * @date: 2020/8/30 8:49 下午
 */

@RestController
@RequestMapping(path = "/users", produces = "application/json")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    @Qualifier(value = "simpleUserService")
    private IUserService userService;

    @GetMapping("/all")
    public List<User> findAllUsers() {
        return userService.findAll();
    }

}
