package edu.estu.estufastingrestapi.core.service.abstracts.infrastructure;

import edu.estu.estufastingrestapi.core.domain.response.abstraction.ApiResponse;
import edu.estu.estufastingrestapi.core.service.model.abstraction.IdentifiableModel;

import javax.validation.Valid;

public interface UpdatableService<ModelType extends IdentifiableModel<?>> extends EntityService {

    ApiResponse update(@Valid ModelType model);

}
