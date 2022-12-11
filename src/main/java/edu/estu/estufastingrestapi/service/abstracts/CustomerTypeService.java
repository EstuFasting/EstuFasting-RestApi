package edu.estu.estufastingrestapi.service.abstracts;

import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.CreatableService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.EntityService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.ReadableService;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceResponse;
import edu.estu.estufastingrestapi.service.model.request.customertype.CustomerTypeCreateRequestModel;

public interface CustomerTypeService extends EntityService, CreatableService<CustomerTypeCreateRequestModel>, ReadableService<Integer> {

    ServiceResponse updateName(Integer id, String name);

    ServiceResponse updateDesc(Integer id, String desc);
}
