package edu.estu.estufastingrestapi.service.abstracts;

import edu.estu.estufastingrestapi.core.domain.response.abstraction.ApiResponse;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.CreatableService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.EntityService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.ReadableService;
import edu.estu.estufastingrestapi.core.service.model.request.pagerequest.PageRequestModel;
import edu.estu.estufastingrestapi.service.model.request.dininghall.DiningHallCreateRequestModel;

public interface DiningHallService extends EntityService, CreatableService<DiningHallCreateRequestModel>, ReadableService<Integer> {
    ApiResponse updateDesc(Integer id, String desc);

    ApiResponse updateAddress(Integer id, String address);

    ApiResponse updateLatitudeAndLongitude(Integer id, Double latitude, Double longitude);

    ApiResponse updateCapacity(Integer id, Integer capacity);

    <P> ApiResponse getOneFullyJoinedId(Integer id, Class<P> projection);

    <P> ApiResponse getListFullyJoined(PageRequestModel pageRequestModel, Class<P> projection);

    ApiResponse updateName(Integer id, String name);

    ApiResponse addMeal(Integer diningHallId, Integer mealId);

    ApiResponse removeMeal(Integer diningHallId, Integer mealId);
}
