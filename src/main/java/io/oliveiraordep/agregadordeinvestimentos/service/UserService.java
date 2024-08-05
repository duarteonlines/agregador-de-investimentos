package io.oliveiraordep.agregadordeinvestimentos.service;

import io.oliveiraordep.agregadordeinvestimentos.controller.dto.CreateUserDto;
import io.oliveiraordep.agregadordeinvestimentos.entity.User;
import io.oliveiraordep.agregadordeinvestimentos.exception.exceptions.UserNotFoundException;
import io.oliveiraordep.agregadordeinvestimentos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(CreateUserDto data) {
        var newUser = createUserDtoToUser(data);
        return userRepository.save(newUser);
    }

    public User getUserById(String userId) {
        return verifyExistsUser(userId);
    }

    private User verifyExistsUser(String userId) {
        var stringToUuid = UUID.fromString(userId);
        return userRepository.findById(stringToUuid).orElseThrow(() -> new UserNotFoundException(stringToUuid));
    }

    private User createUserDtoToUser(CreateUserDto data) {
        return new User(UUID.randomUUID(), data.username(),
                data.email(),
                data.password(),
                Instant.now(),
                null);
    }
}
