package io.oliveiraordep.agregadordeinvestimentos.controller;

import io.oliveiraordep.agregadordeinvestimentos.exception.StandardException;
import io.oliveiraordep.agregadordeinvestimentos.exception.exceptions.UserNotFoundException;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(StandardException.class)
    public ProblemDetail handleStandardException(StandardException e) {
        return e.toProblemDetail();
    }
}
