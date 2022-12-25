package edu.estu.estufastingrestapi.service.concretes;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.domain.entity.abstracts.Identifiable;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.BaseReadableServiceImpl;
import edu.estu.estufastingrestapi.core.service.helper.EntityServiceHelper;
import edu.estu.estufastingrestapi.core.service.model.abstraction.Model;
import edu.estu.estufastingrestapi.core.service.model.request.pagerequest.PageRequestModel;
import edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct.MapStructMapper;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceDataResponse;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceResponse;
import edu.estu.estufastingrestapi.core.service.response.helper.ResponseHelper;
import edu.estu.estufastingrestapi.core.service.response.success.ServiceSuccessDataResponse;
import edu.estu.estufastingrestapi.entities.concretes.Catering;
import edu.estu.estufastingrestapi.entities.concretes.MenuItem;
import edu.estu.estufastingrestapi.repository.abstracts.CateringRepository;
import edu.estu.estufastingrestapi.service.abstracts.CateringService;
import edu.estu.estufastingrestapi.service.model.request.catering.CateringCreateRequestModel;
import edu.estu.estufastingrestapi.service.model.request.catering.CateringMenuUpdateRequestModel;
import edu.estu.estufastingrestapi.service.model.response.catering.CateringResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class CateringServiceImpl extends BaseReadableServiceImpl<Catering, UUID> implements CateringService {

    private final CateringRepository cateringRepository;
    private final MapStructMapper<CateringCreateRequestModel, Catering> createRequestMapper;
    private final MapStructMapper<Catering, CateringResponse> cateringResponseMapper;

    @Override
    public <P> ServiceResponse getOneFullyJoinedById(UUID id, Class<P> projection) {
        return new ServiceSuccessDataResponse<>(cateringRepository.findFirstFullyJoinedById(id, projection), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public <P> ServiceResponse getListFullyJoined(PageRequestModel pageRequestModel, Class<P> projection) {
        return new ServiceSuccessDataResponse<>(cateringRepository.findFullyJoined(pageRequestMapper.map(pageRequestModel), projection), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public <P> ServiceResponse getListByDateBetween(PageRequestModel pageRequestModel, Class<P> projection, LocalDate lowerBound, LocalDate upperBound) {
        return new ServiceSuccessDataResponse<>(cateringRepository.findAllByDateBetween(lowerBound, upperBound, pageRequestMapper.map(pageRequestModel), projection), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public ServiceDataResponse<Model> create(CateringCreateRequestModel model) {
        Catering saved = EntityServiceHelper.saveAndRefresh(cateringRepository, createRequestMapper.map(model));
        return new ServiceSuccessDataResponse<>(cateringResponseMapper.map(saved), MsgCode.COMMON_SUCCESS_SAVED);
    }

    @Override
    public ServiceResponse updateMenuItems(CateringMenuUpdateRequestModel model) {
        Catering catering = cateringRepository.getReferenceById(model.getCateringId());
        boolean changed = model.getMenuItemIds().size() != catering.getMenuItems().size();
        for (MenuItem menuItem : catering.getMenuItems())
            if (!model.getMenuItemIds().contains(menuItem.getId())) {
                changed = true;
                break;
            }
        if (!changed) return ResponseHelper.getResponseBySuccess(true, MsgCode.COMMON_SUCCESS_UPDATED);
        catering.getMenuItems().clear();
        for (UUID menuItemId : model.getMenuItemIds())
            catering.getMenuItems().add(Identifiable.getInstance(MenuItem::new, menuItemId));
        return ResponseHelper.getResponseBySuccess(true, MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ServiceResponse addMenuItem(UUID cateringId, UUID menuItemId) {
        return ResponseHelper.getResponseBySuccess(cateringRepository.addMenuItem(cateringId, menuItemId), MsgCode.CATERING_MENU_ITEM_ADD_SUCCESS);
    }

    @Override
    public ServiceResponse removeMenuItem(UUID cateringId, UUID menuItemId) {
        return ResponseHelper.getResponseBySuccess(cateringRepository.removeMenuItem(cateringId, menuItemId), MsgCode.CATERING_MENU_ITEM_REMOVE_SUCCESS);
    }

}
