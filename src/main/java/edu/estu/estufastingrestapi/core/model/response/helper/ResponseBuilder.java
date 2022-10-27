package edu.estu.estufastingrestapi.core.model.response.helper;

import edu.estu.estufastingrestapi.core.model.response.abstracts.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseBuilder<R extends ApiResponse> extends ResponseEntity<R> {

    public ResponseBuilder() {
        super(HttpStatus.OK);
    }

    public static BodyBuilder status(HttpStatus status) {
        return ResponseEntity.status(status);
    }
}
