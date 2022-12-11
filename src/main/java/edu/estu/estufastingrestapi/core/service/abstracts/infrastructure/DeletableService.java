package edu.estu.estufastingrestapi.core.service.abstracts.infrastructure;

import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceResponse;

public interface DeletableService<ID> extends EntityService {

    ServiceResponse delete(ID id);

}
