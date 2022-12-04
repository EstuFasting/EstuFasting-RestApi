package edu.estu.estufastingrestapi.core.service.abstracts.infrastructure;

import edu.estu.estufastingrestapi.core.domain.response.abstraction.ApiResponse;
import edu.estu.estufastingrestapi.core.service.model.request.pagerequest.PageRequestModel;

public interface ReadableService<Prop> extends EntityService {

    <P> ApiResponse getOneByIdentifier(Prop prop, Class<P> projection);

    <P> ApiResponse getList(PageRequestModel pageRequestModel, Class<P> projection);

}
