package org.bshg.librarysystem.utils.webservice.restapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RestApiUtils {
    private RestApiUtils() {
    }

    public static <T> ResponseEntity<T> reponse(T body) {
        return ResponseEntity.ok(body);
    }

    public static <T> ResponseEntity<T> reponse(T body, HttpStatus status) {
        return new ResponseEntity<>(body, status);
    }

    public static <T> ResponseEntity<T> reponse(HttpStatus status) {
        return new ResponseEntity<>(status);
    }
}
