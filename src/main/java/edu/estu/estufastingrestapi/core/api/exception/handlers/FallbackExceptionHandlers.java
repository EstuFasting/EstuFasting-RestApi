package edu.estu.estufastingrestapi.core.api.exception.handlers;

import edu.estu.estufastingrestapi.core.api.common.ResponseBuilder;
import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.domain.response.abstraction.ApiResponse;
import edu.estu.estufastingrestapi.core.domain.response.error.ApiErrorDataResponse;
import edu.estu.estufastingrestapi.core.domain.response.error.ApiErrorResponse;
import org.springframework.beans.TypeMismatchException;
import org.springframework.core.NestedRuntimeException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Objects;
import java.util.Set;

@ControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
public class FallbackExceptionHandlers {

    @ExceptionHandler(PropertyReferenceException.class)
    public ResponseEntity<ApiResponse> handlePropertyReferenceException(PropertyReferenceException exception) {
        return ResponseBuilder.status(HttpStatus.BAD_REQUEST)
                .body(new ApiErrorResponse(exception.getLocalizedMessage()));
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ApiResponse> handleMissingServletRequestParameterException(MissingServletRequestParameterException exception) {
        return ResponseBuilder.status(HttpStatus.BAD_REQUEST)
                .body(new ApiErrorDataResponse<>(exception, "Please enter the " + exception.getParameterName() + " parameter of type " + exception.getParameterType()));
    }

    @ExceptionHandler(TypeMismatchException.class)
    public ResponseEntity<Object> handleTypeMismatchException(final TypeMismatchException exception) {
        final String message = exception.getValue() + " value for " + exception.getPropertyName() + " should be of type " + exception.getRequiredType();
        return ResponseBuilder.status(HttpStatus.BAD_REQUEST)
                .body(new ApiErrorDataResponse<>(exception, message));
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Object> handleHttpRequestMethodNotSupportedException(final HttpRequestMethodNotSupportedException exception) {
        Set<HttpMethod> supportedMethods = exception.getSupportedHttpMethods();
        final StringBuilder builder = new StringBuilder();
        if (supportedMethods != null) {
            int size = supportedMethods.size();
            builder.append('\'').append(exception.getMethod()).append('\'').append(" method is not supported for this request. Supported method");
            if (size == 1) builder.append(" is ");
            else builder.append("s are ");
            short counter = 0;
            for (HttpMethod httpMethod : supportedMethods) {
                if (counter == size - 1 && size != 1) builder.append(" and ");
                else if (counter != 0 && size != 1) builder.append(", ");
                builder.append('\'').append(httpMethod).append('\'');
                counter++;
            }
        } else builder.append("There is no supported method for this request.");
        return ResponseBuilder.status(HttpStatus.METHOD_NOT_ALLOWED)
                .body(new ApiErrorDataResponse<>(exception, builder.toString()));
    }

    @ExceptionHandler(MissingServletRequestPartException.class)
    public ResponseEntity<Object> handleMissingServletRequestPartException(final MissingServletRequestPartException exception) {
        final String message = exception.getRequestPartName() + " part is missing";
        return ResponseBuilder.status(HttpStatus.BAD_REQUEST)
                .body(new ApiErrorDataResponse<>(exception, message));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleMethodArgumentTypeMismatchException(final MethodArgumentTypeMismatchException exception) {
        final String message = exception.getName() + " should be of type " + Objects.requireNonNull(exception.getRequiredType()).getName();
        return ResponseBuilder.status(HttpStatus.BAD_REQUEST)
                .body(new ApiErrorDataResponse<>(exception, message));
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    protected ResponseEntity<Object> handleNoHandlerFoundException(final NoHandlerFoundException exception) {
        final String message = "No handler found for " + exception.getHttpMethod() + " " + exception.getRequestURL();
        return ResponseBuilder.status(HttpStatus.NOT_FOUND)
                .body(new ApiErrorDataResponse<>(exception, message));
    }

    @ExceptionHandler(NestedRuntimeException.class)
    public ResponseEntity<ApiResponse> handleNestedRuntimeException(NestedRuntimeException exception) {
        return ResponseBuilder.status(HttpStatus.BAD_REQUEST)
                .body(new ApiErrorDataResponse<>(exception, MsgCode.COMMON_ERROR));
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ApiResponse> handleThrowable(Throwable exception) {
        return ResponseBuilder.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiErrorDataResponse<>(exception));
    }

}
