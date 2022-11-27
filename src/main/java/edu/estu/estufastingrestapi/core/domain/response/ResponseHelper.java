package edu.estu.estufastingrestapi.core.domain.response;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.domain.response.abstraction.ApiResponse;
import edu.estu.estufastingrestapi.core.domain.response.error.ApiErrorResponse;
import edu.estu.estufastingrestapi.core.domain.response.success.ApiSuccessResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ResponseHelper {

    public static ApiResponse getResponseBySuccess(boolean success) {
        if (success) return new ApiSuccessResponse(MsgCode.COMMON_SUCCESS_UPDATED);
        return new ApiErrorResponse(MsgCode.COMMON_ERROR_INVALID);
    }

}
