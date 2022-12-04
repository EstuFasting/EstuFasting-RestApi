package edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct;

import edu.estu.estufastingrestapi.core.domain.entity.concretes.Role;
import edu.estu.estufastingrestapi.core.service.model.response.role.RoleResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = PrivilegeResponseMapStructMapper.class)
public abstract class RoleResponseMapStructMapper implements MapStructMapper<Role, RoleResponse> {
}
