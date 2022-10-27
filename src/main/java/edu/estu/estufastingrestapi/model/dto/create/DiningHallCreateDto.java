package edu.estu.estufastingrestapi.model.dto.create;

import javax.validation.constraints.NotNull;

public class DiningHallCreateDto {

    @NotNull
    private String name;

    @NotNull
    private String addressLine1;

    private String addressLine2;

    private Integer capacity;

}
