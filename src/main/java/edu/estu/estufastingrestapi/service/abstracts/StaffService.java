package edu.estu.estufastingrestapi.service.abstracts;

import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.CreatableService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.EntityService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.ReadableService;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceResponse;
import edu.estu.estufastingrestapi.service.model.request.staff.StaffCreateRequestModel;

public interface StaffService extends EntityService, CreatableService<StaffCreateRequestModel>, ReadableService<String> {

    ServiceResponse getCount();

    <P> ServiceResponse getOneFullyJoinedByUsername(String username, Class<P> projection);

}
