package edu.estu.estufastingrestapi.core.service.abstracts.infrastructure;

import edu.estu.estufastingrestapi.core.domain.response.abstraction.ApiResponse;
import edu.estu.estufastingrestapi.core.service.model.request.pagerequest.PageRequestModel;

import javax.validation.Valid;

public interface ReadableService<Prop> extends EntityService {

    <P> ApiResponse getOneByProp(Prop prop, Class<P> projection);

    <P> ApiResponse getList(PageRequestModel pageRequestModel, Class<P> projection);

}
