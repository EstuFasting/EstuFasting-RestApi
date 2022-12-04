package edu.estu.estufastingrestapi.service.objectmapping.mapstruct;

import edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct.MapStructMapper;
import edu.estu.estufastingrestapi.entities.concretes.CustomerType;
import edu.estu.estufastingrestapi.service.model.response.customertype.CustomerTypeResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CustomerTypeResponseMapStructMapper implements MapStructMapper<CustomerType, CustomerTypeResponse> {
}
