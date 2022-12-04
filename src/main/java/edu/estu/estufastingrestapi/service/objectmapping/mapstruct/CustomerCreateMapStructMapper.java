package edu.estu.estufastingrestapi.service.objectmapping.mapstruct;

import edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct.MapStructMapper;
import edu.estu.estufastingrestapi.entities.concretes.Customer;
import edu.estu.estufastingrestapi.service.model.request.customer.CustomerCreateRequestModel;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Setter(onMethod = @__(@Autowired))
@Mapper(componentModel = "spring")
public abstract class CustomerCreateMapStructMapper implements MapStructMapper<CustomerCreateRequestModel, Customer> {

    protected BCryptPasswordEncoder passwordEncoder;

    @Mapping(target = "password", expression = "java(passwordEncoder.encode(source.getPassword()))")
    @Mapping(target = "language.id", source = "source.languageId")
    public abstract Customer map(CustomerCreateRequestModel source);

    @Mapping(target = "password", expression = "java(passwordEncoder.encode(source.getPassword()))")
    @Mapping(target = "language.id", source = "source.languageId")
    public abstract Customer mapInto(CustomerCreateRequestModel source, @MappingTarget Customer destination);

    @Mapping(target = "password", expression = "java(null)")
    @Mapping(target = "languageId", source = "destination.language.id")
    public abstract CustomerCreateRequestModel mapReverse(Customer destination);

}


