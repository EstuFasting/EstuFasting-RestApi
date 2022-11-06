package edu.estu.estufastingrestapi.core.service.abstracts.infrastructure;

import edu.estu.estufastingrestapi.core.model.response.abstracts.ApiResponse;

public interface DeletableService<ID> extends EntityService {

    ApiResponse delete(ID id);

}
