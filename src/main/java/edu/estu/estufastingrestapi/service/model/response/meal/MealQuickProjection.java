package edu.estu.estufastingrestapi.service.model.response.meal;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.estu.estufastingrestapi.core.service.model.abstraction.IdentifiableModel;

import java.time.LocalTime;

public interface MealQuickProjection extends IdentifiableModel<Integer> {

    String getName();

    @JsonFormat(pattern = "hh:mm")
    LocalTime getStart();

    @JsonFormat(pattern = "hh:mm")
    LocalTime getEnd();

}
