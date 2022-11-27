package edu.estu.estufastingrestapi.core.domain.response.error;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.domain.helper.ExceptionTools;
import edu.estu.estufastingrestapi.core.domain.response.abstraction.ApiDataResponse;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class ApiErrorDataResponse<T> extends ApiDataResponse<T> {

    private final String debugMessage;

    public ApiErrorDataResponse(Throwable ex, String debugMessage, T data, String messageCode, Object... args) {
        super(data, messageCode, args);
        this.debugMessage = debugMessage;
        ex.printStackTrace();
        log.info("An exception has handled: " + ex.getClass().getSimpleName());
    }

    public ApiErrorDataResponse(Throwable ex, String debugMessage, T data, String messageCode) {
        this(ex, debugMessage, data, messageCode, (Object[]) null);
    }

    public ApiErrorDataResponse(Throwable ex, T data, String messageCode, Object... args) {
        this(ex, ExceptionTools.getRootCause(ex).getLocalizedMessage(), data, messageCode, args);
    }

    public ApiErrorDataResponse(Throwable ex, T data, String messageCode) {
        this(ex, ExceptionTools.getRootCause(ex).getLocalizedMessage(), data, messageCode, (Object[]) null);
    }

    public ApiErrorDataResponse(Throwable ex, String messageCode) {
        this(ex, ExceptionTools.getRootCause(ex).getLocalizedMessage(), null, messageCode, (Object[]) null);
    }

    public ApiErrorDataResponse(Throwable ex) {
        this(ex, ExceptionTools.getRootCause(ex).getLocalizedMessage(), null, MsgCode.COMMON_ERROR, (Object[]) null);
    }

    public ApiErrorDataResponse(String debugMessage, T data, String messageCode, Object... args) {
        this(new Throwable(), debugMessage, data, messageCode, args);
    }

}
