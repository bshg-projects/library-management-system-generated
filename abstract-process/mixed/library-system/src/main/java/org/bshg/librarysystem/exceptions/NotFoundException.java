package org.bshg.librarysystem.exceptions;

import org.bshg.librarysystem.utils.exception.AbstractAppException;
import org.springframework.http.HttpStatus;

public class NotFoundException extends AbstractAppException {
    @Override
    protected void config() {
        config(HttpStatus.NOT_FOUND);
    }

    public NotFoundException(String message) {
        super(message);
    }
}
