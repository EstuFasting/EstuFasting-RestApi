package sk6.my.templateproject.core.model.response.helper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import sk6.my.templateproject.core.model.response.abstracts.ApiResponse;

public class ResponseBuilder<R extends ApiResponse> extends ResponseEntity<R> {

    public ResponseBuilder() {
        super(HttpStatus.OK);
    }

    public static BodyBuilder status(HttpStatus status) {
        return ResponseEntity.status(status);
    }
}
