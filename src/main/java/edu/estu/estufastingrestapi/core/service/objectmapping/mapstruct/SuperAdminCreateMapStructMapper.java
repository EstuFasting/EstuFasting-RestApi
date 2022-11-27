package edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct;

import edu.estu.estufastingrestapi.core.domain.entity.concretes.SuperAdmin;
import edu.estu.estufastingrestapi.core.service.model.request.superadmin.SuperAdminCreateRequestModel;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Setter(onMethod = @__(@Autowired))
@Mapper(componentModel = "spring")
public abstract class SuperAdminCreateMapStructMapper implements MapStructMapper<SuperAdminCreateRequestModel, SuperAdmin> {

    protected BCryptPasswordEncoder passwordEncoder;

    @Mapping(target = "password", expression = "java(passwordEncoder.encode(source.getPassword()))")
    @Mapping(target = "language.id", source = "source.languageId")
    public abstract SuperAdmin map(SuperAdminCreateRequestModel source);

    @Mapping(target = "password", expression = "java(passwordEncoder.encode(source.getPassword()))")
    @Mapping(target = "language.id", source = "source.languageId")
    public abstract SuperAdmin mapInto(SuperAdminCreateRequestModel source, @MappingTarget SuperAdmin destination);

    @Mapping(target = "password", expression = "java(null)")
    @Mapping(target = "languageId", source = "destination.language.id")
    public abstract SuperAdminCreateRequestModel mapReverse(SuperAdmin destination);

}
