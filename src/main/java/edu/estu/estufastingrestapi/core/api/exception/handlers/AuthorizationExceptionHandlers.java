package edu.estu.estufastingrestapi.core.api.exception.handlers;

import edu.estu.estufastingrestapi.core.api.common.ResponseBuilder;
import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.domain.response.abstraction.ApiResponse;
import edu.estu.estufastingrestapi.core.domain.response.error.ApiErrorDataResponse;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.AccessDeniedException;

@RequiredArgsConstructor
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AuthorizationExceptionHandlers {

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ApiResponse> handleAccessDeniedException(AccessDeniedException exception) {
        return ResponseBuilder.status(HttpStatus.UNAUTHORIZED)
                .body(new ApiErrorDataResponse<>(exception, exception.getMessage()));
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ApiResponse> handleAuthenticationException(AuthenticationException exception) {
        return ResponseBuilder.status(HttpStatus.UNAUTHORIZED)
                .body(new ApiErrorDataResponse<>(exception, exception.getMessage()));
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<ApiResponse> handleJwtException(ExpiredJwtException exception) {
        return ResponseBuilder.status(HttpStatus.UNAUTHORIZED)
                .body(new ApiErrorDataResponse<>(exception, MsgCode.SECURITY_RE_LOGIN_JWT_EXPIRED));
    }

    @ExceptionHandler(JwtException.class)
    public ResponseEntity<ApiResponse> handleJwtException(JwtException exception) {
        return ResponseBuilder.status(HttpStatus.UNAUTHORIZED)
                .body(new ApiErrorDataResponse<>(exception, exception.getMessage()));
    }

}
