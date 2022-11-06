package edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct.abstracts;

import edu.estu.estufastingrestapi.core.model.dto.superadmin.SuperAdminCreateDto;
import edu.estu.estufastingrestapi.core.model.entities.concretes.SuperAdmin;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class SuperAdminCreateMapStructMapper implements MapStructMapper<SuperAdminCreateDto, SuperAdmin> {

    @Mapping(target = "language.id", source = "src.languageId")
    public abstract SuperAdmin map(SuperAdminCreateDto src);

    @Mapping(target = "languageId", source = "src.language.id")
    public abstract SuperAdminCreateDto mapReverse(SuperAdmin src);

}
