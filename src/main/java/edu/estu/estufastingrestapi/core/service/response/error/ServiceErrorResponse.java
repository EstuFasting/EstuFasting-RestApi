package edu.estu.estufastingrestapi.core.service.response.error;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceResponse;

public class ServiceErrorResponse extends ServiceResponse {

    public ServiceErrorResponse(String messageCode, Object... args) {
        super(messageCode, args);
    }

    public ServiceErrorResponse(String messageCode) {
        this(messageCode, (Object[]) null);
    }

    public ServiceErrorResponse() {
        this(MsgCode.COMMON_ERROR, (Object[]) null);
    }

}
