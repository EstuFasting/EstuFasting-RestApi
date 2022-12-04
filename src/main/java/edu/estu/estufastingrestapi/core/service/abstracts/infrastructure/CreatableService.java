package edu.estu.estufastingrestapi.core.service.abstracts.infrastructure;

import edu.estu.estufastingrestapi.core.domain.response.abstraction.ApiResponse;
import edu.estu.estufastingrestapi.core.service.model.request.abstraction.RequestModel;

public interface CreatableService<ModelType extends RequestModel> extends EntityService {

    ApiResponse create(ModelType model);

}
