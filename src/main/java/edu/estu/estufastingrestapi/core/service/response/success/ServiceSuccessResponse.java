package edu.estu.estufastingrestapi.core.service.response.success;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceResponse;

public class ServiceSuccessResponse extends ServiceResponse {

    public ServiceSuccessResponse(String messageCode, Object... args) {
        super(messageCode, args);
    }

    public ServiceSuccessResponse(String messageCode) {
        this(messageCode, (Object[]) null);
    }

    public ServiceSuccessResponse() {
        this(MsgCode.COMMON_SUCCESS, (Object[]) null);
    }

}
