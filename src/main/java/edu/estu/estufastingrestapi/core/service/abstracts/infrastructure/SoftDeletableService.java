package edu.estu.estufastingrestapi.core.service.abstracts.infrastructure;

import edu.estu.estufastingrestapi.core.model.dto.pagerequest.PageRequestDto;
import edu.estu.estufastingrestapi.core.model.response.abstracts.ApiResponse;

import javax.validation.Valid;

public interface SoftDeletableService extends EntityService {

    <P> ApiResponse getByDeletedTrue(@Valid PageRequestDto pageRequestDto, Class<P> projection);

}
