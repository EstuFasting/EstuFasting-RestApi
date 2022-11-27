package edu.estu.estufastingrestapi.core.service.abstracts;

import edu.estu.estufastingrestapi.core.domain.response.abstraction.ApiResponse;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.CreatableService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.EntityService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.ReadableService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.UpdatableService;
import edu.estu.estufastingrestapi.core.service.model.request.language.LanguageCreateRequestModel;
import edu.estu.estufastingrestapi.core.service.model.request.language.LanguageUpdateRequestModel;

public interface LanguageService extends EntityService, CreatableService<LanguageCreateRequestModel>, ReadableService<Integer>, UpdatableService<LanguageUpdateRequestModel> {
    <P> ApiResponse getByAlpha2(String alpha2, Class<P> projection);

    ApiResponse updateName(Integer id, String name);

    ApiResponse updateLocalName(Integer id, String localName);

    ApiResponse updateAlpha2(Integer id, String alpha2);

    ApiResponse updateAlpha3T(Integer id, String alpha3T);

    ApiResponse updateUnlisted(Integer id, Boolean unlisted);

    ApiResponse updateSupported(Integer id, Boolean unlisted);
}
