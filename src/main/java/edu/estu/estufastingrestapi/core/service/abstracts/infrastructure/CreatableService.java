package edu.estu.estufastingrestapi.core.service.abstracts.infrastructure;

import edu.estu.estufastingrestapi.core.service.model.abstraction.Model;
import edu.estu.estufastingrestapi.core.service.model.request.abstraction.RequestModel;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceDataResponse;

public interface CreatableService<ModelType extends RequestModel> extends EntityService {

    ServiceDataResponse<Model> create(ModelType model);

}
