package edu.estu.estufastingrestapi.core.service.abstracts.infrastructure;

import edu.estu.estufastingrestapi.core.domain.response.abstraction.ApiResponse;
import edu.estu.estufastingrestapi.core.service.model.request.pagerequest.PageRequestModel;

import javax.validation.Valid;

public interface ReadableService<ID> extends EntityService {

    <P> ApiResponse getById(ID id, Class<P> projection);

    <P> ApiResponse get(@Valid PageRequestModel pageRequestModel, Class<P> projection);

}
