package edu.estu.estufastingrestapi.service.abstracts;

import edu.estu.estufastingrestapi.core.domain.response.abstraction.ApiResponse;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.CreatableService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.EntityService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.ReadableService;
import edu.estu.estufastingrestapi.service.model.request.customer.CustomerCreateRequestModel;

import java.util.UUID;

public interface CustomerService extends EntityService, CreatableService<CustomerCreateRequestModel>, ReadableService<String> {


    <P> ApiResponse getOneFullyJoinedByUsername(String username, Class<P> projection);

    ApiResponse updateType(UUID id, Integer customerTypeId);

    ApiResponse makeReservation(UUID customerId, UUID cateringId);

    ApiResponse cancelReservation(UUID customerId, UUID cateringId);
}
