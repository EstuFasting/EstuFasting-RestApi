package edu.estu.estufastingrestapi.service.abstracts;

import edu.estu.estufastingrestapi.core.domain.response.abstraction.ApiResponse;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.CreatableService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.EntityService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.ReadableService;
import edu.estu.estufastingrestapi.service.model.request.meal.MealCreateRequestModel;

import java.time.LocalTime;

public interface MealService extends EntityService, CreatableService<MealCreateRequestModel>, ReadableService<Integer> {

    ApiResponse updateName(Integer id, String name);

    ApiResponse updateStart(Integer id, LocalTime start);

    ApiResponse updateEnd(Integer id, LocalTime end);

}
