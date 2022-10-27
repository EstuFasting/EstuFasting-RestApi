package sk6.my.templateproject.core.model.response.success;

import sk6.my.templateproject.core.model.response.abstracts.ApiDataResponse;
import sk6.my.templateproject.core.model.response.helper.Msg;

public class ApiSuccessDataResponse<T> extends ApiDataResponse<T> {

    public ApiSuccessDataResponse(String message, T data) {
        super(message, data);
    }

    public ApiSuccessDataResponse(String message) {
        this(message, null);
    }

    public ApiSuccessDataResponse(T data) {
        this(Msg.SUCCESS, data);
    }

    public ApiSuccessDataResponse() {
        this(Msg.SUCCESS, null);
    }
}