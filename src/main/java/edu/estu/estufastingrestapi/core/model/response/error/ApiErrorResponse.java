package sk6.my.templateproject.core.model.response.error;

import sk6.my.templateproject.core.model.response.abstracts.ApiResponse;
import sk6.my.templateproject.core.model.response.helper.Msg;

public class ApiErrorResponse extends ApiResponse {

    public ApiErrorResponse(String message) {
        super(message);
    }

    public ApiErrorResponse() {
        this(Msg.UNEXPECTED_ERROR);
    }

}
