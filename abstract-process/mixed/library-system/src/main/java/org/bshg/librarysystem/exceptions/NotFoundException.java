package org.bshg.librarysystem.exceptions;
import org.springframework.http.HttpStatus;

import org.springframework.http.HttpStatus;
import org.bshg.librarysystem.utils.exception.AbstractAppException;

public class NotFoundException extends AbstractAppException {
    @Override
    protected void config() {
        config(HttpStatus.NOT_FOUND);
    }

    public NotFoundException(String message) {
        super(message);
    }
}
