package edu.estu.estufastingrestapi.core.domain.helper;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ExceptionTools {

    public static Throwable getRootCause(Throwable throwable) {
        if (throwable == null) return null;
        Throwable rootCause = throwable;
        while (rootCause.getCause() != null && rootCause.getCause() != rootCause)
            rootCause = rootCause.getCause();
        return rootCause;
    }

}
