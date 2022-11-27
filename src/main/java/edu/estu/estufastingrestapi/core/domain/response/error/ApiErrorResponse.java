package edu.estu.estufastingrestapi.core.domain.response.error;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.domain.response.abstraction.ApiResponse;

public class ApiErrorResponse extends ApiResponse {

    public ApiErrorResponse(String messageCode, Object... args) {
        super(messageCode, args);
    }

    public ApiErrorResponse(String messageCode) {
        this(messageCode, (Object[]) null);
    }

    public ApiErrorResponse() {
        this(MsgCode.COMMON_ERROR, (Object[]) null);
    }

}
