package org.bshg.librarysystem.utils.exception;

import org.springframework.http.HttpStatus;

public abstract class AbstractAppException extends RuntimeException {
protected String message;
private HttpStatus status;

protected AbstractAppException(String message) {
this.message = message;
this.config();
}

protected void config(HttpStatus status) {
this.status = status;
}

protected abstract void config();

public ApiError getError() {
return new ApiError(message, status);
}

public HttpStatus getStatus() {
return status;
}

@Override
public String getMessage() {
return message;
}
}
