package edu.estu.estufastingrestapi.core.service.response.helper;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceResponse;
import edu.estu.estufastingrestapi.core.service.response.error.ServiceErrorResponse;
import edu.estu.estufastingrestapi.core.service.response.success.ServiceSuccessResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ResponseHelper {

    public static ServiceResponse getResponseBySuccess(boolean success, String successMsgCode) {
        if (success) return new ServiceSuccessResponse(successMsgCode);
        return new ServiceErrorResponse(MsgCode.COMMON_ERROR_INVALID);
    }

    public static ServiceResponse getResponseBySuccess(int numOfRowsToBeUpdated, String successMsgCode) {
        return getResponseBySuccess(numOfRowsToBeUpdated > 0, successMsgCode);
    }

}
