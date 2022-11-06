package edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct.abstracts;

import edu.estu.estufastingrestapi.core.model.dto.language.LanguageUpdateDto;
import edu.estu.estufastingrestapi.core.model.entities.concretes.Language;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class LanguageUpdateMapStructMapper implements MapStructMapper<LanguageUpdateDto, Language> {

    public abstract Language map(LanguageUpdateDto dto);

    public abstract LanguageUpdateDto mapReverse(Language entity);

}
