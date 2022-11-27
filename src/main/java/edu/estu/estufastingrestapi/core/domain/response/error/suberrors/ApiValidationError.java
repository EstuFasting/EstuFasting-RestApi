package edu.estu.estufastingrestapi.core.domain.response.error.suberrors;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.estu.estufastingrestapi.core.domain.response.abstraction.ApiSubError;

public record ApiValidationError(
        String field,
        @JsonFormat(shape = JsonFormat.Shape.STRING)
        Object rejectedValue,
        String code,
        String message) implements ApiSubError {
}
