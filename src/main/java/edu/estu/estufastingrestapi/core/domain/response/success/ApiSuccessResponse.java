package edu.estu.estufastingrestapi.core.domain.response.success;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.domain.response.abstraction.ApiResponse;

public class ApiSuccessResponse extends ApiResponse {

    public ApiSuccessResponse(String messageCode, Object... args) {
        super(messageCode, args);
    }

    public ApiSuccessResponse(String messageCode) {
        this(messageCode, (Object[]) null);
    }

    public ApiSuccessResponse() {
        this(MsgCode.COMMON_SUCCESS, (Object[]) null);
    }

}
