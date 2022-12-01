package edu.estu.estufastingrestapi.core.service.abstracts;

import edu.estu.estufastingrestapi.core.domain.response.abstraction.ApiResponse;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.CreatableService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.EntityService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.ReadableService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.UpdatableService;
import edu.estu.estufastingrestapi.core.service.model.request.superadmin.SuperAdminCreateRequestModel;
import edu.estu.estufastingrestapi.core.service.model.request.superadmin.SuperAdminUpdateRequestModel;

import javax.validation.Valid;
import java.util.UUID;

public interface SuperAdminService extends EntityService, CreatableService<SuperAdminCreateRequestModel>, ReadableService<String>, UpdatableService<SuperAdminUpdateRequestModel> {

    @Override
    <P> ApiResponse getOneByProp(String username, Class<P> projection);

    <P> ApiResponse getOneFullyJoinedByUsername(String username, Class<P> projection);
}
