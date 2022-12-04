package edu.estu.estufastingrestapi.service.model.response.meal;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalTime;

public interface MealQuickProjection {

    Integer getId();

    String getName();

    @JsonFormat(pattern = "hh:mm")
    LocalTime getStart();

    @JsonFormat(pattern = "hh:mm")
    LocalTime getEnd();

}
