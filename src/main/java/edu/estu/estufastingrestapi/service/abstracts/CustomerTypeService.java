package edu.estu.estufastingrestapi.service.abstracts;

import edu.estu.estufastingrestapi.core.domain.response.abstraction.ApiResponse;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.CreatableService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.EntityService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.ReadableService;
import edu.estu.estufastingrestapi.service.model.request.customertype.CustomerTypeCreateRequestModel;

public interface CustomerTypeService extends EntityService, CreatableService<CustomerTypeCreateRequestModel>, ReadableService<Integer> {

    ApiResponse updateName(Integer id, String name);

    ApiResponse updateDesc(Integer id, String desc);
}
