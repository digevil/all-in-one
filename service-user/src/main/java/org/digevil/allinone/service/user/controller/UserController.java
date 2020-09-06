package org.digevil.allinone.service.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.digevil.allinone.service.user.model.User;
import org.digevil.allinone.service.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author: toni
 * @date: 2020/9/5 5:56 下午
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Get total count of users")
    @GetMapping("/count")
    public long countTotal() {
        return userService.countTotal();
    }

    @Operation(summary = "Get user info by user id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "found user",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = User.class))}),
            @ApiResponse(
                    responseCode = "404",
                    description = "user not found",
                    content = {@Content}
            )
    })
    @GetMapping("/find/{id}")
    public User findById(@PathVariable("id") int id) {
        return userService.findById(id);
    }

    @GetMapping("/find")
    public List<User> find(@RequestParam(name = "name", required = false) String name, @RequestParam(name = "uuid", required = false) String uuid) {
        User example = new User();
        Optional.ofNullable(name).ifPresent(nm -> example.setName(nm));
        Optional.ofNullable(uuid).ifPresent(uid -> example.setUuid(uid));
        return userService.findAll(example);
    }

    @PostMapping("/")
    public User save(@RequestBody String userName) {
        User newUser = new User();
        newUser.setName(userName);
        newUser.setUuid(UUID.randomUUID().toString());
        return userService.save(newUser);
    }
}
