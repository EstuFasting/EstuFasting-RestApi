package edu.estu.estufastingrestapi.core.service.abstracts.infrastructure;

import edu.estu.estufastingrestapi.core.domain.response.abstraction.ApiResponse;

public interface DeletableService<ID> extends EntityService {

    ApiResponse delete(ID id);

}
