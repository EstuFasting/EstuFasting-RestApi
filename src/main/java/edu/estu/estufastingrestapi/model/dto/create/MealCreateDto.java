package edu.estu.estufastingrestapi.model.dto.create;

import javax.validation.constraints.NotNull;
import java.time.LocalTime;

public class MealCreateDto {

    @NotNull
    private String name;

    @NotNull
    private LocalTime start;

    @NotNull
    private LocalTime end;

}
