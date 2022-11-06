package edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct.abstracts;

import edu.estu.estufastingrestapi.core.model.dto.language.LanguageCreateDto;
import edu.estu.estufastingrestapi.core.model.entities.concretes.Language;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class LanguageCreateMapStructMapper implements MapStructMapper<LanguageCreateDto, Language> {

    public abstract Language map(LanguageCreateDto dto);

    public abstract LanguageCreateDto mapReverse(Language entity);

}
