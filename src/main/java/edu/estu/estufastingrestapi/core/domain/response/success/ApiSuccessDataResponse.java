package edu.estu.estufastingrestapi.core.domain.response.success;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.domain.response.abstraction.ApiDataResponse;

public class ApiSuccessDataResponse<T> extends ApiDataResponse<T> {

    public ApiSuccessDataResponse(T data, String messageCode, Object... args) {
        super(data, messageCode, args);
    }

    public ApiSuccessDataResponse(T data, String messageCode) {
        this(data, messageCode, (Object[]) null);
    }

    public ApiSuccessDataResponse(T data) {
        this(data, MsgCode.COMMON_SUCCESS, (Object[]) null);
    }

}
