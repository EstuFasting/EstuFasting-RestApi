package edu.estu.estufastingrestapi.service.concretes;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.BaseReadableServiceImpl;
import edu.estu.estufastingrestapi.core.service.helper.EntityServiceHelper;
import edu.estu.estufastingrestapi.core.service.model.abstraction.Model;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceDataResponse;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceResponse;
import edu.estu.estufastingrestapi.core.service.response.helper.ResponseHelper;
import edu.estu.estufastingrestapi.core.service.response.success.ServiceSuccessDataResponse;
import edu.estu.estufastingrestapi.entities.concretes.Meal;
import edu.estu.estufastingrestapi.repository.abstracts.MealRepository;
import edu.estu.estufastingrestapi.service.abstracts.MealService;
import edu.estu.estufastingrestapi.service.model.request.meal.MealCreateRequestModel;
import edu.estu.estufastingrestapi.service.objectmapping.mapstruct.MealCreateMapStructMapper;
import edu.estu.estufastingrestapi.service.objectmapping.mapstruct.MealResponseMapStructMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalTime;

@Service
@Transactional
@RequiredArgsConstructor
public class MealServiceImpl extends BaseReadableServiceImpl<Meal, Integer> implements MealService {

    private final MealRepository mealRepository;
    private final MealResponseMapStructMapper mealResponseMapper;
    private final MealCreateMapStructMapper mealCreateMapper;

    @Override
    public ServiceResponse getCount() {
        return new ServiceSuccessDataResponse<>(mealRepository.count(), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public ServiceDataResponse<Model> create(MealCreateRequestModel model) {
        Meal saved = EntityServiceHelper.saveAndRefresh(mealRepository, mealCreateMapper.map(model));
        return new ServiceSuccessDataResponse<>(mealResponseMapper.map(saved), MsgCode.COMMON_SUCCESS_SAVED);
    }

    @Override
    public ServiceResponse updateName(Integer id, String name) {
        return ResponseHelper.getResponseBySuccess(mealRepository.updateName(id, name), MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ServiceResponse updateStart(Integer id, LocalTime start) {
        return ResponseHelper.getResponseBySuccess(mealRepository.updateStart(id, start), MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ServiceResponse updateEnd(Integer id, LocalTime end) {
        return ResponseHelper.getResponseBySuccess(mealRepository.updateEnd(id, end), MsgCode.COMMON_SUCCESS_UPDATED);
    }

}
