package edu.estu.estufastingrestapi.service.abstracts;

import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.CreatableService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.EntityService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.ReadableService;
import edu.estu.estufastingrestapi.core.service.model.request.pagerequest.PageRequestModel;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceResponse;
import edu.estu.estufastingrestapi.service.model.request.dininghall.DiningHallCreateRequestModel;

public interface DiningHallService extends EntityService, CreatableService<DiningHallCreateRequestModel>, ReadableService<Integer> {

    ServiceResponse getCount();

    ServiceResponse getTotalCapacity();

    <P> ServiceResponse getOneFullyJoinedId(Integer id, Class<P> projection);

    <P> ServiceResponse getListFullyJoined(PageRequestModel pageRequestModel, Class<P> projection);

    ServiceResponse updateName(Integer id, String name);

    ServiceResponse updateDesc(Integer id, String desc);

    ServiceResponse updateAddress(Integer id, String address);

    ServiceResponse updateLatitudeAndLongitude(Integer id, Double latitude, Double longitude);

    ServiceResponse updateCapacity(Integer id, Integer capacity);

    ServiceResponse addMeal(Integer diningHallId, Integer mealId);

    ServiceResponse removeMeal(Integer diningHallId, Integer mealId);
}
