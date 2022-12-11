package edu.estu.estufastingrestapi.service.abstracts;

import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.CreatableService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.EntityService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.ReadableService;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceDataResponse;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceResponse;
import edu.estu.estufastingrestapi.entities.concretes.Customer;
import edu.estu.estufastingrestapi.service.model.request.customer.CustomerCreateRequestModel;

import java.util.UUID;

public interface CustomerService extends EntityService, CreatableService<CustomerCreateRequestModel>, ReadableService<String> {

    ServiceDataResponse<Customer> getByTckn(String tckn);

    <P> ServiceResponse getOneFullyJoinedByUsername(String username, Class<P> projection);

    ServiceResponse updateType(UUID id, Integer customerTypeId);

}
