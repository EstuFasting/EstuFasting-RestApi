package edu.estu.estufastingrestapi.core.exception.handlers;

import edu.estu.estufastingrestapi.core.exception.helper.ExceptionHelper;
import edu.estu.estufastingrestapi.core.model.response.abstracts.ApiResponse;
import edu.estu.estufastingrestapi.core.model.response.abstracts.ApiSubError;
import edu.estu.estufastingrestapi.core.model.response.error.ApiErrorDataResponse;
import edu.estu.estufastingrestapi.core.model.response.error.ApiErrorResponse;
import edu.estu.estufastingrestapi.core.model.response.error.suberrors.ApiValidationError;
import edu.estu.estufastingrestapi.core.model.response.helper.Msg;
import edu.estu.estufastingrestapi.core.model.response.helper.ResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ControllerAdvice
public class ValidationExceptionHandlers {

    @ExceptionHandler(BindException.class)
    public ResponseEntity<ApiResponse> handleBindException(BindException ex) {
        Stream<ApiSubError> fieldErrors = ex.getFieldErrors().stream()
                .map(err -> new ApiValidationError(err.getObjectName(), err.getField(), err.getRejectedValue(), err.getDefaultMessage()));
        Stream<ApiSubError> objErrors = ex.getGlobalErrors().stream()
                .map(err -> new ApiValidationError(err.getObjectName(), err.getDefaultMessage()));
        return ResponseBuilder
                .status(HttpStatus.BAD_REQUEST)
                .body(new ApiErrorDataResponse<>(ex, Msg.INVALID, Stream.concat(fieldErrors, objErrors).toList()));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiResponse> handleValidationException(ConstraintViolationException ex) {
        Stream<ApiSubError> errors = ex.getConstraintViolations().stream()
                .map(err -> new ApiValidationError(err.getPropertyPath(), err.getInvalidValue(), err.getMessage()));
        return ResponseBuilder
                .status(HttpStatus.BAD_REQUEST)
                .body(new ApiErrorDataResponse<>(ex, Msg.INVALID, errors.toList()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseBuilder
                .status(HttpStatus.BAD_REQUEST)
                .body(new ApiErrorResponse(ExceptionHelper.getTheMostSpecificCause(ex).getLocalizedMessage()));
    }

}
