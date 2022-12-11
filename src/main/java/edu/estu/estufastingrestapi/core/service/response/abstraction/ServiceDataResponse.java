package edu.estu.estufastingrestapi.core.service.response.abstraction;

import lombok.Getter;

@Getter
public abstract class ServiceDataResponse<T> extends ServiceResponse {

    private final T data;

    protected ServiceDataResponse(T data, String messageCode, Object[] args) {
        super(messageCode, args);
        this.data = data;
    }

    protected ServiceDataResponse(T data, String messageCode) {
        this(data, messageCode, null);
    }

}
