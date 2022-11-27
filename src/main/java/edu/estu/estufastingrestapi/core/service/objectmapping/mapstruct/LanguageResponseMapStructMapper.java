package edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct;

import edu.estu.estufastingrestapi.core.domain.entity.concretes.Language;
import edu.estu.estufastingrestapi.core.service.model.response.language.LanguageResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class LanguageResponseMapStructMapper implements MapStructMapper<LanguageResponse, Language> {
}
