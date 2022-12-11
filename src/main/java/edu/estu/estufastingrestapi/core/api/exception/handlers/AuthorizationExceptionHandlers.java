package edu.estu.estufastingrestapi.core.api.exception.handlers;

import edu.estu.estufastingrestapi.core.api.common.ResponseBuilder;
import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceResponse;
import edu.estu.estufastingrestapi.core.service.response.error.ServiceErrorDataResponse;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RequiredArgsConstructor
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AuthorizationExceptionHandlers {

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ServiceResponse> handleAccessDeniedException(AccessDeniedException exception) {
        return ResponseBuilder.status(HttpStatus.UNAUTHORIZED)
                .body(new ServiceErrorDataResponse<>(exception, MsgCode.SECURITY_ACCESS_IS_DENIED));
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ServiceResponse> handleAuthenticationException(AuthenticationException exception) {
        return ResponseBuilder.status(HttpStatus.UNAUTHORIZED)
                .body(new ServiceErrorDataResponse<>(exception, MsgCode.SECURITY_ACCESS_IS_DENIED));
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<ServiceResponse> handleJwtException(ExpiredJwtException exception) {
        return ResponseBuilder.status(HttpStatus.UNAUTHORIZED)
                .body(new ServiceErrorDataResponse<>(exception, MsgCode.SECURITY_RE_LOGIN_JWT_EXPIRED));
    }

    @ExceptionHandler(JwtException.class)
    public ResponseEntity<ServiceResponse> handleJwtException(JwtException exception) {
        return ResponseBuilder.status(HttpStatus.UNAUTHORIZED)
                .body(new ServiceErrorDataResponse<>(exception, MsgCode.COMMON_ERROR_AUTHENTICATION));
    }

}
