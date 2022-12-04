package edu.estu.estufastingrestapi.service.objectmapping.mapstruct;

import edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct.MapStructMapper;
import edu.estu.estufastingrestapi.entities.concretes.Meal;
import edu.estu.estufastingrestapi.service.model.response.meal.MealResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = DiningHallResponseMapStructMapper.class)
public abstract class MealResponseMapStructMapper implements MapStructMapper<Meal, MealResponse> {
}
