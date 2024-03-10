package org.bshg.librarysystem.utils.webservice.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ApiError {
    private final String message;
    private final HttpStatus status;
    private final int statusCode;
    private final ZonedDateTime timestamp;

    public ApiError(String error, HttpStatus status, int statusCode, ZonedDateTime timestamp) {
        this.message = error;
        this.status = status;
        this.statusCode = statusCode;
        this.timestamp = timestamp;
    }

    public static ApiErrorBuilder builder() {
        return new ApiErrorBuilder();
    }

    public String getMessage() {
        return this.message;
    }

    public HttpStatus getStatus() {
        return this.status;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public ZonedDateTime getTimestamp() {
        return this.timestamp;
    }

    public static class ApiErrorBuilder {
        private String message;
        private HttpStatus status;
        private int statusCode;
        private ZonedDateTime timestamp;

        ApiErrorBuilder() {
        }

        public ApiErrorBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ApiErrorBuilder status(HttpStatus status) {
            this.status = status;
            return this;
        }

        public ApiErrorBuilder statusCode(int statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        public ApiErrorBuilder timestamp(ZonedDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public ApiError build() {
            return new ApiError(this.message, this.status, this.statusCode, this.timestamp);
        }

        public String toString() {
            return "ApiError.ApiErrorBuilder(message=" + this.message + ", status=" + this.status + ", statusCode=" + this.statusCode + ", timestamp=" + this.timestamp + ")";
        }
    }
}
