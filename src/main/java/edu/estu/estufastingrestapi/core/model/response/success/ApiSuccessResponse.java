package edu.estu.estufastingrestapi.core.model.response.success;

import edu.estu.estufastingrestapi.core.model.response.abstracts.ApiResponse;
import edu.estu.estufastingrestapi.core.model.response.helper.Msg;

public class ApiSuccessResponse extends ApiResponse {

    public ApiSuccessResponse(String message) {
        super(message);
    }

    public ApiSuccessResponse() {
        this(Msg.SUCCESS);
    }

}
