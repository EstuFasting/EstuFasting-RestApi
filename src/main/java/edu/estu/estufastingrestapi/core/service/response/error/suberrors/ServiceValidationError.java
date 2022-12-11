package edu.estu.estufastingrestapi.core.service.response.error.suberrors;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceSubError;

public record ServiceValidationError(
        String field,
        @JsonFormat(shape = JsonFormat.Shape.STRING) Object rejectedValue,
        String code,
        String message) implements ServiceSubError {
}
