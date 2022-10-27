package edu.estu.estufastingrestapi.core.model.response.error;

import edu.estu.estufastingrestapi.core.model.response.abstracts.ApiResponse;
import edu.estu.estufastingrestapi.core.model.response.helper.Msg;

public class ApiErrorResponse extends ApiResponse {

    public ApiErrorResponse(String message) {
        super(message);
    }

    public ApiErrorResponse() {
        this(Msg.UNEXPECTED_ERROR);
    }

}
