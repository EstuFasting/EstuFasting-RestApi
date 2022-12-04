package edu.estu.estufastingrestapi.service.objectmapping.mapstruct;

import edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct.MapStructMapper;
import edu.estu.estufastingrestapi.entities.concretes.Staff;
import edu.estu.estufastingrestapi.service.model.request.staff.StaffCreateRequestModel;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Setter(onMethod = @__(@Autowired))
@Mapper(componentModel = "spring")
public abstract class StaffCreateMapStructMapper implements MapStructMapper<StaffCreateRequestModel, Staff> {

    protected BCryptPasswordEncoder passwordEncoder;

    @Mapping(target = "password", expression = "java(passwordEncoder.encode(source.getPassword()))")
    @Mapping(target = "language.id", source = "source.languageId")
    public abstract Staff map(StaffCreateRequestModel source);

    @Mapping(target = "password", expression = "java(passwordEncoder.encode(source.getPassword()))")
    @Mapping(target = "language.id", source = "source.languageId")
    public abstract Staff mapInto(StaffCreateRequestModel source, @MappingTarget Staff destination);

    @Mapping(target = "password", expression = "java(null)")
    @Mapping(target = "languageId", source = "destination.language.id")
    public abstract StaffCreateRequestModel mapReverse(Staff destination);

}


