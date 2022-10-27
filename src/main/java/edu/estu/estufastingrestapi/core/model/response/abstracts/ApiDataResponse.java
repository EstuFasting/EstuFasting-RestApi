package edu.estu.estufastingrestapi.core.model.response.abstracts;

import lombok.Getter;

@Getter
public abstract class ApiDataResponse<DataType> extends ApiResponse {

    private final DataType data;

    public ApiDataResponse(DataType data) {
        super();
        this.data = data;
    }

    public ApiDataResponse(String message, DataType data) {
        super(message);
        this.data = data;
    }

}
