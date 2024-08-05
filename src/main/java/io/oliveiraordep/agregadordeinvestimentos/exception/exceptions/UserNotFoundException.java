package io.oliveiraordep.agregadordeinvestimentos.exception.exceptions;

import io.oliveiraordep.agregadordeinvestimentos.exception.StandardException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

import java.util.UUID;

public class UserNotFoundException extends StandardException {

    private final UUID userId;

    public UserNotFoundException(UUID userId){
        this.userId = userId;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        pb.setTitle("User not found");
        pb.setDetail("There is no user with id: " + userId);
        return pb;
    }
}
