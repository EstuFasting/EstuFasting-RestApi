package edu.estu.estufastingrestapi.core.model.response.abstracts;

import lombok.Getter;

@Getter

public abstract class ApiDataResponse<T> extends ApiResponse {

    private final T data;

    protected ApiDataResponse(T data) {
        super();
        this.data = data;
    }

    protected ApiDataResponse(String message, T data) {
        super(message);
        this.data = data;
    }

}
