package edu.estu.estufastingrestapi.service.model.response.dininghall;

import edu.estu.estufastingrestapi.service.model.response.meal.MealQuickProjection;

import java.util.Set;

public interface DiningHallFullyJoinedProjection {

    String getName();

    String getDescription();

    String getAddress();

    Double getLatitude();

    Double getLongitude();

    Integer getCapacity();

    Set<MealQuickProjection> getMeals();

}
