package edu.estu.estufastingrestapi.core.model.response.abstracts;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public abstract class ApiResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private final LocalDateTime timestamp;
    private String message;

    protected ApiResponse() {
        this.timestamp = LocalDateTime.now();
    }

    protected ApiResponse(String message) {
        this();
        this.message = message;
    }

}
