package edu.estu.estufastingrestapi.service.objectmapping.mapstruct;

import edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct.MapStructMapper;
import edu.estu.estufastingrestapi.entities.concretes.Meal;
import edu.estu.estufastingrestapi.service.model.request.meal.MealCreateRequestModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class MealCreateMapStructMapper implements MapStructMapper<MealCreateRequestModel, Meal> {
}


