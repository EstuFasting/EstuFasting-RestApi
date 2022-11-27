package edu.estu.estufastingrestapi.core.api.exception.handlers;

import edu.estu.estufastingrestapi.core.api.common.ResponseBuilder;
import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.domain.helper.StringTools;
import edu.estu.estufastingrestapi.core.domain.response.abstraction.ApiResponse;
import edu.estu.estufastingrestapi.core.domain.response.error.ApiErrorDataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;
import java.sql.SQLException;
import java.util.Optional;

@RequiredArgsConstructor
@ControllerAdvice
@Order(0)
public class PersistenceExceptionHandlers {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiResponse> handleEntityNotFoundException(EntityNotFoundException exception) {
        return ResponseBuilder.status(HttpStatus.BAD_REQUEST)
                .body(new ApiErrorDataResponse<>(exception, exception.getMessage() == null ? MsgCode.COMMON_ERROR_ENTITY_NOT_FOUND : exception.getMessage()));
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<ApiResponse> handleEmptyResultDataAccessException(EmptyResultDataAccessException exception) {
        return ResponseBuilder.status(HttpStatus.BAD_REQUEST)
                .body(new ApiErrorDataResponse<>(exception, MsgCode.COMMON_ERROR_ENTITY_NOT_FOUND));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiResponse> handleDataIntegrityViolationException(DataIntegrityViolationException exception) {
        Optional<String> code = StringTools.extract(exception.getMessage(), "(fk|uk)_\\w+_\\w+").map(m -> "DB.Constraint." + m);
        return ResponseBuilder.status(HttpStatus.BAD_REQUEST)
                .body(new ApiErrorDataResponse<>(exception, code.orElse(MsgCode.COMMON_ERROR_INVALID)));
    }

    @ExceptionHandler(PersistenceException.class)
    public ResponseEntity<ApiResponse> handlePersistenceException(PersistenceException exception) {
        return ResponseBuilder.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiErrorDataResponse<>(exception, exception.getLocalizedMessage()));
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ApiResponse> handleSQLException(SQLException exception) {
        return ResponseBuilder.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiErrorDataResponse<>(exception, exception.getLocalizedMessage()));
    }

}
