package sk6.my.templateproject.core.model.response.success;

import sk6.my.templateproject.core.model.response.abstracts.ApiResponse;
import sk6.my.templateproject.core.model.response.helper.Msg;

public class ApiSuccessResponse extends ApiResponse {

    public ApiSuccessResponse(String message) {
        super(message);
    }

    public ApiSuccessResponse() {
        this(Msg.SUCCESS);
    }

}
