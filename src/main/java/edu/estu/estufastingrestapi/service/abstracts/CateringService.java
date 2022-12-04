package edu.estu.estufastingrestapi.service.abstracts;

import edu.estu.estufastingrestapi.core.domain.response.abstraction.ApiResponse;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.CreatableService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.EntityService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.ReadableService;
import edu.estu.estufastingrestapi.core.service.model.request.pagerequest.PageRequestModel;
import edu.estu.estufastingrestapi.service.model.request.catering.CateringCreateRequestModel;

import java.util.UUID;

public interface CateringService extends EntityService, CreatableService<CateringCreateRequestModel>, ReadableService<UUID> {
    <P> ApiResponse getOneFullyJoinedById(UUID id, Class<P> projection);

    <P> ApiResponse getListFullyJoined(PageRequestModel pageRequestModel, Class<P> projection);

    ApiResponse addMenuItem(UUID cateringId, UUID menuItemId);

    ApiResponse removeMenuItem(UUID cateringId, UUID menuItemId);
}
