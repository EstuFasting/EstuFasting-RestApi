package edu.estu.estufastingrestapi.core.domain.response.abstraction;

import lombok.Getter;

@Getter
public abstract class ApiDataResponse<T> extends ApiResponse {

    private final T data;

    protected ApiDataResponse(T data, String messageCode, Object[] args) {
        super(messageCode, args);
        this.data = data;
    }

    protected ApiDataResponse(T data, String messageCode) {
        this(data, messageCode, null);
    }

}
