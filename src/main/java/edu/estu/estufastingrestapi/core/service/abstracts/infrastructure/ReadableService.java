package edu.estu.estufastingrestapi.core.service.abstracts.infrastructure;

import edu.estu.estufastingrestapi.core.service.model.request.pagerequest.PageRequestModel;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceDataResponse;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceResponse;

public interface ReadableService<Prop> extends EntityService {

    <P> ServiceDataResponse<P> getOneByIdentifier(Prop prop, Class<P> projection);

    <P> ServiceResponse getList(PageRequestModel pageRequestModel, Class<P> projection);

}
