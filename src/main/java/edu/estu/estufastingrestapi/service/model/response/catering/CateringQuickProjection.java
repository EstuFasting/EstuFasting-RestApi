package edu.estu.estufastingrestapi.service.model.response.catering;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.estu.estufastingrestapi.core.service.model.abstraction.IdentifiableModel;
import edu.estu.estufastingrestapi.service.model.response.meal.MealQuickProjection;

import java.time.LocalDate;
import java.util.UUID;

public interface CateringQuickProjection extends IdentifiableModel<UUID> {

    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate getDate();

    MealQuickProjection getMeal();

    Double getPrice();

}
