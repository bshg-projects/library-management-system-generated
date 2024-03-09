package org.bshg.librarysystem.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.bshg.librarysystem.utils.exception.AbstractAppException;
import org.bshg.librarysystem.utils.exception.ApiError;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(AbstractAppException.class)
    public <T extends AbstractAppException> ResponseEntity<ApiError> handleCostumeExceptions(T e) {
        var error = e.getError();
        return ResponseEntity
                .status(error.getStatus())
                .body(error);
    }
}
