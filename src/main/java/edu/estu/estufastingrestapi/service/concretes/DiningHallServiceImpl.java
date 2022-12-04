package edu.estu.estufastingrestapi.service.concretes;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.domain.response.ResponseHelper;
import edu.estu.estufastingrestapi.core.domain.response.abstraction.ApiResponse;
import edu.estu.estufastingrestapi.core.domain.response.success.ApiSuccessDataResponse;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.BaseReadableServiceImpl;
import edu.estu.estufastingrestapi.core.service.helper.EntityServiceHelper;
import edu.estu.estufastingrestapi.core.service.model.request.pagerequest.PageRequestModel;
import edu.estu.estufastingrestapi.entities.concretes.DiningHall;
import edu.estu.estufastingrestapi.repository.abstracts.DiningHallRepository;
import edu.estu.estufastingrestapi.service.abstracts.DiningHallService;
import edu.estu.estufastingrestapi.service.model.request.dininghall.DiningHallCreateRequestModel;
import edu.estu.estufastingrestapi.service.objectmapping.mapstruct.DiningHallCreateMapStructMapper;
import edu.estu.estufastingrestapi.service.objectmapping.mapstruct.DiningHallResponseMapStructMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DiningHallServiceImpl extends BaseReadableServiceImpl<DiningHall, Integer> implements DiningHallService {

    private final DiningHallRepository diningHallRepository;
    private final DiningHallResponseMapStructMapper diningHallResponseMapper;
    private final DiningHallCreateMapStructMapper diningHallCreateMapper;

    @Override
    public <P> ApiResponse getOneFullyJoinedId(Integer id, Class<P> projection) {
        return new ApiSuccessDataResponse<>(diningHallRepository.findFirstFullyJoinedById(id, projection), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public <P> ApiResponse getListFullyJoined(PageRequestModel pageRequestModel, Class<P> projection) {
        return new ApiSuccessDataResponse<>(diningHallRepository.findFullyJoined(pageRequestMapper.map(pageRequestModel), projection), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public ApiResponse create(DiningHallCreateRequestModel model) {
        DiningHall saved = EntityServiceHelper.saveAndRefresh(diningHallRepository, diningHallCreateMapper.map(model));
        return new ApiSuccessDataResponse<>(diningHallResponseMapper.map(saved), MsgCode.COMMON_SUCCESS_SAVED);
    }

    @Override
    public ApiResponse updateName(Integer id, String name) {
        return ResponseHelper.getResponseBySuccess(diningHallRepository.updateName(id, name), MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ApiResponse updateDesc(Integer id, String desc) {
        return ResponseHelper.getResponseBySuccess(diningHallRepository.updateDesc(id, desc), MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ApiResponse updateAddress(Integer id, String address) {
        return ResponseHelper.getResponseBySuccess(diningHallRepository.updateAddress(id, address), MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ApiResponse updateLatitudeAndLongitude(Integer id, Double latitude, Double longitude) {
        return ResponseHelper.getResponseBySuccess(diningHallRepository.updateLatitudeAndLongitude(id, latitude, longitude), MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ApiResponse updateCapacity(Integer id, Integer capacity) {
        return ResponseHelper.getResponseBySuccess(diningHallRepository.updateCapacity(id, capacity), MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ApiResponse addMeal(Integer diningHallId, Integer mealId) {
        return ResponseHelper.getResponseBySuccess(diningHallRepository.addMeal(diningHallId, mealId), MsgCode.DINING_HALL_MEAL_ADD_SUCCESS);
    }

    @Override
    public ApiResponse removeMeal(Integer diningHallId, Integer mealId) {
        return ResponseHelper.getResponseBySuccess(diningHallRepository.removeMeal(diningHallId, mealId), MsgCode.DINING_HALL_MEAL_REMOVE_SUCCESS);
    }

}
