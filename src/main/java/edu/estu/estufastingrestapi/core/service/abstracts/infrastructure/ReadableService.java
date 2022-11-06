package edu.estu.estufastingrestapi.core.service.abstracts.infrastructure;

import edu.estu.estufastingrestapi.core.model.dto.pagerequest.PageRequestDto;
import edu.estu.estufastingrestapi.core.model.response.abstracts.ApiResponse;

import javax.validation.Valid;

public interface ReadableService extends EntityService {

    <P> ApiResponse get(@Valid PageRequestDto dto, Class<P> projection);

}
