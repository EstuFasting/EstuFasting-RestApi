package edu.estu.estufastingrestapi.core.exception.helper;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ExceptionHelper {

    public Throwable getTheMostSpecificCause(Throwable throwable) {
        Throwable cause = throwable;
        while (cause.getCause() != null)
            cause = cause.getCause();
        return cause;
    }

}
