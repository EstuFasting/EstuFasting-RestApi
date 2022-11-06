package edu.estu.estufastingrestapi.core.exception.handlers;

import edu.estu.estufastingrestapi.core.model.response.abstracts.ApiResponse;
import edu.estu.estufastingrestapi.core.model.response.error.ApiErrorDataResponse;
import edu.estu.estufastingrestapi.core.model.response.error.ApiErrorResponse;
import edu.estu.estufastingrestapi.core.model.response.helper.ResponseBuilder;
import org.springframework.core.NestedRuntimeException;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(NestedRuntimeException.class)
    public ResponseEntity<ApiResponse> handleNestedRuntimeException(NestedRuntimeException exception) {
        return ResponseBuilder
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiErrorDataResponse<>(exception, exception.getMostSpecificCause().getLocalizedMessage()));
    }

    @ExceptionHandler(PropertyReferenceException.class)
    public ResponseEntity<ApiResponse> handlePropertyReferenceException(PropertyReferenceException exception) {
        return ResponseBuilder
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiErrorResponse(exception.getLocalizedMessage()));
    }

}
