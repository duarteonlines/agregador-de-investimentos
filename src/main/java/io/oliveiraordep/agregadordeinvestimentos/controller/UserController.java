package io.oliveiraordep.agregadordeinvestimentos.controller;

import io.oliveiraordep.agregadordeinvestimentos.controller.dto.CreateUserDto;
import io.oliveiraordep.agregadordeinvestimentos.entity.User;
import io.oliveiraordep.agregadordeinvestimentos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserDto data) {
        var user = userService.createUser(data);
        return ResponseEntity.created(URI.create("/v1/users"
                + user.getId()
                .toString()))
                .build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") String userId){
        var user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }
}
