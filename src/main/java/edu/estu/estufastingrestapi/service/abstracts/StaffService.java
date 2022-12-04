package edu.estu.estufastingrestapi.service.abstracts;

import edu.estu.estufastingrestapi.core.domain.response.abstraction.ApiResponse;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.CreatableService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.EntityService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.ReadableService;
import edu.estu.estufastingrestapi.service.model.request.staff.StaffCreateRequestModel;

public interface StaffService extends EntityService, CreatableService<StaffCreateRequestModel>, ReadableService<String> {

    <P> ApiResponse getOneFullyJoinedByUsername(String username, Class<P> projection);

}
