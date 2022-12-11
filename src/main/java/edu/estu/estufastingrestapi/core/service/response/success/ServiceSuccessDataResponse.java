package edu.estu.estufastingrestapi.core.service.response.success;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceDataResponse;

public class ServiceSuccessDataResponse<T> extends ServiceDataResponse<T> {

    public ServiceSuccessDataResponse(T data, String messageCode, Object... args) {
        super(data, messageCode, args);
    }

    public ServiceSuccessDataResponse(T data, String messageCode) {
        this(data, messageCode, (Object[]) null);
    }

    public ServiceSuccessDataResponse(T data) {
        this(data, MsgCode.COMMON_SUCCESS, (Object[]) null);
    }

}
