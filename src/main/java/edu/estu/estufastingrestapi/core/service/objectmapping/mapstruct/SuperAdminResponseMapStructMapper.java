package edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct;

import edu.estu.estufastingrestapi.core.domain.entity.concretes.SuperAdmin;
import edu.estu.estufastingrestapi.core.service.model.response.superadmin.SuperAdminResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class SuperAdminResponseMapStructMapper implements MapStructMapper<SuperAdminResponse, SuperAdmin> {
}
