package edu.estu.estufastingrestapi.core.api.common;

import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseBuilder<R extends ServiceResponse> extends ResponseEntity<R> {

    public ResponseBuilder() {
        super(HttpStatus.OK);
    }

    public static BodyBuilder status(HttpStatus status) {
        return ResponseEntity.status(status);
    }

}
