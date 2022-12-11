package edu.estu.estufastingrestapi.service.model.response.catering;

import edu.estu.estufastingrestapi.core.service.model.abstraction.IdentifiableModel;
import edu.estu.estufastingrestapi.service.model.response.meal.MealQuickProjection;

import java.time.LocalDate;
import java.util.UUID;

public interface CateringQuickProjection extends IdentifiableModel<UUID> {

    LocalDate getDate();

    MealQuickProjection getMeal();

    Double getPrice();

}
