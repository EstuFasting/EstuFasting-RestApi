package edu.estu.estufastingrestapi.core.service.abstracts;

import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.CreatableService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.EntityService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.ReadableService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.UpdatableAtOnceService;
import edu.estu.estufastingrestapi.core.service.model.request.language.LanguageCreateRequestModel;
import edu.estu.estufastingrestapi.core.service.model.request.language.LanguageUpdateRequestModel;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceResponse;

public interface LanguageService extends EntityService, CreatableService<LanguageCreateRequestModel>, ReadableService<Integer>, UpdatableAtOnceService<LanguageUpdateRequestModel> {
    <P> ServiceResponse getByAlpha2(String alpha2, Class<P> projection);

    ServiceResponse updateName(Integer id, String name);

    ServiceResponse updateLocalName(Integer id, String localName);

    ServiceResponse updateAlpha2(Integer id, String alpha2);

    ServiceResponse updateAlpha3T(Integer id, String alpha3T);

    ServiceResponse updateUnlisted(Integer id, Boolean unlisted);

    ServiceResponse updateSupported(Integer id, Boolean unlisted);
}
