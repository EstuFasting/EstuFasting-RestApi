package edu.estu.estufastingrestapi.core.api.exception.handlers;

import edu.estu.estufastingrestapi.core.api.common.ResponseBuilder;
import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.domain.response.abstraction.ApiResponse;
import edu.estu.estufastingrestapi.core.domain.response.abstraction.ApiSubError;
import edu.estu.estufastingrestapi.core.domain.response.error.ApiErrorDataResponse;
import edu.estu.estufastingrestapi.core.domain.response.error.ApiErrorResponse;
import edu.estu.estufastingrestapi.core.domain.response.error.suberrors.ApiValidationError;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@ControllerAdvice
@Order(0)
public class ValidationExceptionHandlers {

    @ExceptionHandler(BindException.class)
    public ResponseEntity<ApiResponse> handleBindException(BindException ex) {
        List<ApiSubError> errors = new ArrayList<>(ex.getErrorCount());
        for (FieldError fieldError : ex.getFieldErrors())
            errors.add(new ApiValidationError(fieldError.getField(), fieldError.getRejectedValue(), fieldError.getCode(), fieldError.getDefaultMessage()));
        for (ObjectError globalError : ex.getGlobalErrors())
            errors.add(new ApiValidationError(null, null, globalError.getCode(), globalError.getDefaultMessage()));
        return ResponseBuilder.status(HttpStatus.BAD_REQUEST)
                .body(new ApiErrorDataResponse<>(ex, errors, MsgCode.COMMON_ERROR_INVALID));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiResponse> handleConstraintViolationException(ConstraintViolationException ex) {
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        ArrayList<ApiSubError> errors = new ArrayList<>(violations.size());
        for (ConstraintViolation<?> violation : violations) {
            String propertyPath = violation.getPropertyPath().toString();
            String field = propertyPath.substring(propertyPath.lastIndexOf('.') + 1);
            errors.add(new ApiValidationError(field, violation.getInvalidValue(), violation.getMessageTemplate(), violation.getMessage()));
        }
        return ResponseBuilder.status(HttpStatus.BAD_REQUEST)
                .body(new ApiErrorDataResponse<>(ex, errors, MsgCode.COMMON_ERROR_INVALID));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseBuilder.status(HttpStatus.BAD_REQUEST)
                .body(new ApiErrorResponse(ex.getLocalizedMessage()));
    }

}
