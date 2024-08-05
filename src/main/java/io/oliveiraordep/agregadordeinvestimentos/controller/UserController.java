package io.oliveiraordep.agregadordeinvestimentos.controller;

import io.oliveiraordep.agregadordeinvestimentos.controller.dto.CreateUserDto;
import io.oliveiraordep.agregadordeinvestimentos.controller.dto.UserUpdateDto;
import io.oliveiraordep.agregadordeinvestimentos.entity.User;
import io.oliveiraordep.agregadordeinvestimentos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


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

    @GetMapping
    public ResponseEntity<List<User>> listUsers() {
        var users = userService.listUsers();
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("userId") String userId){
        userService.deleteUserById(userId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Void> updateUserById(@PathVariable("userId") String userId, @RequestBody UserUpdateDto data){
        userService.updateUserById(userId, data);
        return ResponseEntity.noContent().build();
    }
}
