package edu.estu.estufastingrestapi.service.model.response.catering;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.estu.estufastingrestapi.core.service.model.abstraction.IdentifiableModel;
import edu.estu.estufastingrestapi.service.model.response.meal.MealQuickProjection;
import edu.estu.estufastingrestapi.service.model.response.menuitem.MenuItemQuickProjection;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public interface CateringFullyJoinedProjection extends IdentifiableModel<UUID> {

    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate getDate();

    MealQuickProjection getMeal();

    Double getPrice();

    Set<MenuItemQuickProjection> getMenuItems();

}
