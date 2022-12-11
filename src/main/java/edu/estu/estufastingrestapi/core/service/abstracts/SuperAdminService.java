package edu.estu.estufastingrestapi.core.service.abstracts;

import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.CreatableService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.EntityService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.ReadableService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.UpdatableAtOnceService;
import edu.estu.estufastingrestapi.core.service.model.request.superadmin.SuperAdminCreateRequestModel;
import edu.estu.estufastingrestapi.core.service.model.request.superadmin.SuperAdminUpdateRequestModel;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceDataResponse;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceResponse;

public interface SuperAdminService extends EntityService, CreatableService<SuperAdminCreateRequestModel>, ReadableService<String>, UpdatableAtOnceService<SuperAdminUpdateRequestModel> {

    @Override
    <P> ServiceDataResponse<P> getOneByIdentifier(String username, Class<P> projection);

    <P> ServiceResponse getOneFullyJoinedByUsername(String username, Class<P> projection);
}
