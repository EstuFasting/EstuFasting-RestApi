package edu.estu.estufastingrestapi.core.service.objectmapping.abstracts;

import edu.estu.estufastingrestapi.core.model.dto.concretes.create.SuperAdminCreateDto;
import edu.estu.estufastingrestapi.core.model.entities.concretes.SuperAdmin;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class SuperAdminCreateMapStructMapper implements MapStructMapper<SuperAdminCreateDto, SuperAdmin> {

    @Mapping(target = "language.id", source = "dto.languageId")
    public abstract SuperAdmin map(SuperAdminCreateDto dto);

    @Mapping(target = "languageId", source = "entity.language.id")
    public abstract SuperAdminCreateDto mapReverse(SuperAdmin entity);

}
