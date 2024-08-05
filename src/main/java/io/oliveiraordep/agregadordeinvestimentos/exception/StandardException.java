package io.oliveiraordep.agregadordeinvestimentos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class StandardException extends RuntimeException  {

    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        pb.setTitle("Internal Server error");
        return pb;
    }
}
