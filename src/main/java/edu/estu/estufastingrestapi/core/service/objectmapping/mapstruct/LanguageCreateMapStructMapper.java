package edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct;

import edu.estu.estufastingrestapi.core.domain.entity.concretes.Language;
import edu.estu.estufastingrestapi.core.service.model.request.language.LanguageCreateRequestModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class LanguageCreateMapStructMapper implements MapStructMapper<LanguageCreateRequestModel, Language> {
}
