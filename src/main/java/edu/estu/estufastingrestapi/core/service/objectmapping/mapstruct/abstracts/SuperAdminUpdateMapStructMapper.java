package edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct.abstracts;

import edu.estu.estufastingrestapi.core.model.dto.superadmin.SuperAdminUpdateDto;
import edu.estu.estufastingrestapi.core.model.entities.concretes.SuperAdmin;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class SuperAdminUpdateMapStructMapper implements MapStructMapper<SuperAdminUpdateDto, SuperAdmin> {

    @Mapping(target = "language.id", source = "dto.languageId")
    public abstract SuperAdmin map(SuperAdminUpdateDto dto);

    @Mapping(target = "languageId", source = "entity.language.id")
    public abstract SuperAdminUpdateDto mapReverse(SuperAdmin entity);

}
