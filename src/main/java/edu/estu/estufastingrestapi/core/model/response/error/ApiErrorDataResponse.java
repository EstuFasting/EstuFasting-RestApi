package edu.estu.estufastingrestapi.core.model.response.error;

import edu.estu.estufastingrestapi.core.model.response.abstracts.ApiDataResponse;
import edu.estu.estufastingrestapi.core.model.response.helper.Msg;
import lombok.Getter;

@Getter
public class ApiErrorDataResponse<T> extends ApiDataResponse<T> {

    private final String debugMessage;

    public ApiErrorDataResponse(Throwable ex, String message, T data) {
        super(message, data);
        this.debugMessage = ex.getLocalizedMessage().replaceAll("(%s\s)", "");
    }

    public ApiErrorDataResponse(Throwable ex, String message) {
        this(ex, message, null);
    }

    public ApiErrorDataResponse(Throwable ex) {
        this(ex, Msg.UNEXPECTED_ERROR);
    }

}
