package io.oliveiraordep.agregadordeinvestimentos.service;

import io.oliveiraordep.agregadordeinvestimentos.controller.dto.CreateUserDto;
import io.oliveiraordep.agregadordeinvestimentos.controller.dto.UserUpdateDto;
import io.oliveiraordep.agregadordeinvestimentos.entity.User;
import io.oliveiraordep.agregadordeinvestimentos.exception.exceptions.UserNotFoundException;
import io.oliveiraordep.agregadordeinvestimentos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(CreateUserDto data) {
        var userCreated = createUserDtoToUser(data);
        return userRepository.save(userCreated);
    }

    public User getUserById(String userId) {
        verifyExistsUser(userId);
        var uuid  = UUID.fromString(userId);
        return userRepository.findById(uuid).get();
    }

    public List<User> listUsers() {
        return userRepository.findAll();
    }

    public void deleteUserById(String userId) {
        verifyExistsUser(userId);
        var uuid  = UUID.fromString(userId);
        userRepository.deleteById(uuid);
    }

    public void updateUserById(String userId, UserUpdateDto data) {
        verifyExistsUser(userId);
        var userUpdated = updateUserData(userId, data);
        userRepository.save(userUpdated);
    }

    private User updateUserData(String userId, UserUpdateDto data) {
        var uuid  = UUID.fromString(userId);
        var user = userRepository.findById(uuid).get();
        user.setUsername(data.username());
        user.setPassword(data.password());
        return user;
    }

    private void verifyExistsUser(String userId) {
        var stringToUuid = UUID.fromString(userId);
        if(!userRepository.existsById(stringToUuid)){
            throw new UserNotFoundException(stringToUuid);
        }
    }

    private User createUserDtoToUser(CreateUserDto data) {
        return new User(UUID.randomUUID(), data.username(),
                data.email(),
                data.password(),
                Instant.now(),
                null);
    }
}
