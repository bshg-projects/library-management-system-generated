package org.bshg.librarysystem.utils.webservice.restapi;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.sql.Timestamp;

public class ErrorResponse implements Serializable {
private Timestamp timestamp;
private int status;
private String path;
private String error;
private String message;
private String exception;
@JsonIgnore
private HttpStatus httpStatus;
@JsonIgnore
private Exception ex;

public ErrorResponse(HttpStatus httpStatus, Exception ex, String message, String path) {
this.timestamp = new Timestamp(System.currentTimeMillis());
this.status = httpStatus.value();
this.error = httpStatus.getReasonPhrase();
this.exception = ex.getClass().getName();
this.message = message;
this.path = path;
}

public ErrorResponse() {
}

public Timestamp getTimestamp() {
return this.timestamp;
}

public int getStatus() {
return this.status;
}

public String getPath() {
return this.path;
}

public String getError() {
return this.error;
}

public String getMessage() {
return this.message;
}

public String getException() {
return this.exception;
}

public HttpStatus getHttpStatus() {
return this.httpStatus;
}

public Exception getEx() {
return this.ex;
}

public void setTimestamp(Timestamp timestamp) {
this.timestamp = timestamp;
}

public void setStatus(int status) {
this.status = status;
}

public void setPath(String path) {
this.path = path;
}

public void setError(String error) {
this.error = error;
}

public void setMessage(String message) {
this.message = message;
}

public void setException(String exception) {
this.exception = exception;
}

@JsonIgnore
public void setHttpStatus(HttpStatus httpStatus) {
this.httpStatus = httpStatus;
}

@JsonIgnore
public void setEx(Exception ex) {
this.ex = ex;
}
}
