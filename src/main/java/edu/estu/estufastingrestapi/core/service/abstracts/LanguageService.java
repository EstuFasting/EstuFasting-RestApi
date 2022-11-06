package edu.estu.estufastingrestapi.core.service.abstracts;

import edu.estu.estufastingrestapi.core.model.dto.language.LanguageCreateDto;
import edu.estu.estufastingrestapi.core.model.dto.language.LanguageUpdateDto;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.*;

public interface LanguageService extends EntityService, CreatableService<LanguageCreateDto>, ReadableService, UpdatableService<LanguageUpdateDto>, DeletableService<Integer>, SoftDeletableService {
}
