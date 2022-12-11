package edu.estu.estufastingrestapi.service.abstracts;

import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.CreatableService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.EntityService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.ReadableService;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceResponse;
import edu.estu.estufastingrestapi.service.model.request.meal.MealCreateRequestModel;

import java.time.LocalTime;

public interface MealService extends EntityService, CreatableService<MealCreateRequestModel>, ReadableService<Integer> {

    ServiceResponse getCount();

    ServiceResponse updateName(Integer id, String name);

    ServiceResponse updateStart(Integer id, LocalTime start);

    ServiceResponse updateEnd(Integer id, LocalTime end);

}
