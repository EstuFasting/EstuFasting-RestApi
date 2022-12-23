package edu.estu.estufastingrestapi.service.abstracts;

import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.CreatableService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.DeletableService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.EntityService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.ReadableService;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceDataResponse;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceResponse;
import edu.estu.estufastingrestapi.service.model.request.reservation.ReservationCreateRequestModel;

import java.util.List;
import java.util.UUID;

public interface ReservationService extends EntityService, CreatableService<ReservationCreateRequestModel>, ReadableService<UUID>, DeletableService<UUID> {

    ServiceDataResponse<List<?>> createMultiple(List<ReservationCreateRequestModel> models);

    ServiceResponse updatePaid(UUID id, Boolean paid);

    ServiceResponse completePaymentMultiple(List<UUID> ids);
}
