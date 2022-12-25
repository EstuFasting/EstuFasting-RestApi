package edu.estu.estufastingrestapi.service.abstracts;

import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.CreatableService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.EntityService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.ReadableService;
import edu.estu.estufastingrestapi.core.service.model.request.pagerequest.PageRequestModel;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceResponse;
import edu.estu.estufastingrestapi.service.model.request.catering.CateringCreateRequestModel;
import edu.estu.estufastingrestapi.service.model.request.catering.CateringMenuUpdateRequestModel;

import java.time.LocalDate;
import java.util.UUID;

public interface CateringService extends EntityService, CreatableService<CateringCreateRequestModel>, ReadableService<UUID> {
    <P> ServiceResponse getOneFullyJoinedById(UUID id, Class<P> projection);

    <P> ServiceResponse getListFullyJoined(PageRequestModel pageRequestModel, Class<P> projection);

    <P> ServiceResponse getListByDateBetween(PageRequestModel pageRequestModel, Class<P> projection, LocalDate lowerBound, LocalDate upperBound);

    ServiceResponse updateMenuItems(CateringMenuUpdateRequestModel model);

    ServiceResponse addMenuItem(UUID cateringId, UUID menuItemId);

    ServiceResponse removeMenuItem(UUID cateringId, UUID menuItemId);
}
