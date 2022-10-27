package edu.estu.estufastingrestapi.model.dto.create;

import javax.validation.constraints.NotNull;

public class CustomerTypeCreateDto {

    @NotNull
    private String name;

    @NotNull
    private String description;

}
