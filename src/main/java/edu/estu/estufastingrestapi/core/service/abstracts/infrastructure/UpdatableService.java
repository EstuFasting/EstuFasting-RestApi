package edu.estu.estufastingrestapi.core.service.abstracts.infrastructure;

import edu.estu.estufastingrestapi.core.domain.response.abstraction.ApiResponse;
import edu.estu.estufastingrestapi.core.service.model.abstraction.IdentifiableModel;
import edu.estu.estufastingrestapi.core.service.model.request.abstraction.RequestModel;

import javax.validation.Valid;

public interface UpdatableService<ModelType extends RequestModel> extends EntityService {

    ApiResponse update(ModelType model);

}
