package org.bshg.librarysystem.utils.webservice.restapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.function.Supplier;

public abstract class RestApiHelper {
    protected <DTO> ResponseEntity<DTO> sendResponse(boolean isConflict, Supplier<ResponseEntity<DTO>> operation) {
        if (isConflict) new ResponseEntity<>(HttpStatus.CONFLICT);
        return operation.get();
    }

    protected <DTO> ResponseEntity<List<DTO>> sendResponses(boolean isConflict, Supplier<ResponseEntity<List<DTO>>> operation) {
        if (isConflict) new ResponseEntity<>(HttpStatus.CONFLICT);
        return operation.get();
    }

    protected <DTO> ResponseEntity<DTO> sendResponse(boolean isConflict, HttpStatus conflictStatus, Supplier<ResponseEntity<DTO>> operation) {
        if (isConflict) new ResponseEntity<>(conflictStatus);
        return operation.get();
    }

    protected <DTO> ResponseEntity<List<DTO>> sendResponses(boolean isConflict, HttpStatus conflictStatus, Supplier<ResponseEntity<List<DTO>>> operation) {
        if (isConflict) new ResponseEntity<>(conflictStatus);
        return operation.get();
    }

    protected <T> ResponseEntity<T> success(T body) {
        return ResponseEntity.ok(body);
    }
}
