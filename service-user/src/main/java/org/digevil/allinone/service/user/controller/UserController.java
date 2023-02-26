package org.digevil.allinone.service.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.digevil.allinone.service.user.model.User;
import org.digevil.allinone.service.user.service.UserService;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

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

    @Operation(summary = "根据用户id获取用户信息")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "找到用户",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = User.class))}),
            @ApiResponse(
                    responseCode = "404",
                    description = "用户不存在",
                    content = {@Content}
            )
    })
    @GetMapping("/find/{id}")
    public User findById(@Parameter(description = "需要查找的用户id") @PathVariable("id") int id) {
        return userService.findById(id);
    }

    @GetMapping("/find")
    public List<User> find(@RequestParam(name = "name", required = false) String name, @RequestParam(name = "uuid", required = false) String uuid) {
        User example = new User();
        Optional.ofNullable(name).ifPresent(nm -> example.setName(nm));
        Optional.ofNullable(uuid).ifPresent(uid -> example.setUuid(uid));
        return userService.findAll(example);
    }

    @GetMapping("/find/paged")
    public Page<User> findPaged(@ParameterObject Pageable pageable) {
        return userService.findPaged(pageable);
    }

    @PostMapping("/")
    public User save(@RequestBody String userName) {
        User newUser = new User();
        newUser.setName(userName);
        newUser.setUuid(UUID.randomUUID().toString());
        return userService.save(newUser);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable("id") Integer id, @RequestBody User updated) {
        updated.setId(id);
        return userService.save(updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        userService.delete(id);
    }
}
