package edu.estu.estufastingrestapi.service.model.response.catering;

import edu.estu.estufastingrestapi.service.model.response.meal.MealQuickProjection;
import edu.estu.estufastingrestapi.service.model.response.menuitem.MenuItemQuickProjection;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public interface CateringFullyJoinedProjection {

    UUID getId();

    LocalDate getDate();

    MealQuickProjection getMeal();

    Double getPrice();

    Set<MenuItemQuickProjection> getMenuItems();

}
