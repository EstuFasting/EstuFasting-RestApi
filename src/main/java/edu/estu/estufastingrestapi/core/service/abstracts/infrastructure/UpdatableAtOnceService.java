package edu.estu.estufastingrestapi.core.service.abstracts.infrastructure;

import edu.estu.estufastingrestapi.core.service.model.request.abstraction.RequestModel;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceResponse;

public interface UpdatableAtOnceService<ModelType extends RequestModel> extends EntityService {

    ServiceResponse updateChanges(ModelType model);

}
