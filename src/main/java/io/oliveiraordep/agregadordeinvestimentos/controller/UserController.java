package io.oliveiraordep.agregadordeinvestimentos.controller;

import io.oliveiraordep.agregadordeinvestimentos.controller.dto.CreateUserDto;
import io.oliveiraordep.agregadordeinvestimentos.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody CreateUserDto data) {
        return null;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") String userId){
        return null;
    }
}
