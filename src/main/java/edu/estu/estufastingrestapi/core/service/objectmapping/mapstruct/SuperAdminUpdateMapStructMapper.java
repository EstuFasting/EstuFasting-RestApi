package edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct;

import edu.estu.estufastingrestapi.core.domain.entity.concretes.SuperAdmin;
import edu.estu.estufastingrestapi.core.service.model.request.superadmin.SuperAdminUpdateRequestModel;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public abstract class SuperAdminUpdateMapStructMapper implements MapStructMapper<SuperAdminUpdateRequestModel, SuperAdmin> {

    @Mapping(target = "language.id", source = "source.languageId")
    public abstract SuperAdmin map(SuperAdminUpdateRequestModel source);

    @Mapping(target = "language", expression = "java(mapRefIgnoreNull(superAdmin.getLanguage(), Language::new, source.getLanguageId()))")
    public abstract SuperAdmin mapInto(SuperAdminUpdateRequestModel source, @MappingTarget SuperAdmin superAdmin);

    @Mapping(target = "languageId", source = "destination.language.id")
    public abstract SuperAdminUpdateRequestModel mapReverse(SuperAdmin destination);

}
