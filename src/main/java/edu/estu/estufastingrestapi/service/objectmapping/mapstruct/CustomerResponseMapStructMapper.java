package edu.estu.estufastingrestapi.service.objectmapping.mapstruct;

import edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct.LanguageResponseMapStructMapper;
import edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct.MapStructMapper;
import edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct.RoleResponseMapStructMapper;
import edu.estu.estufastingrestapi.entities.concretes.Customer;
import edu.estu.estufastingrestapi.service.model.response.customer.CustomerResponse;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring",
        uses = {
                LanguageResponseMapStructMapper.class,
                RoleResponseMapStructMapper.class,
                CustomerTypeResponseMapStructMapper.class,
                CateringResponseMapStructMapper.class
        })
public abstract class CustomerResponseMapStructMapper implements MapStructMapper<Customer, CustomerResponse> {
}
