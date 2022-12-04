package edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct;

import edu.estu.estufastingrestapi.core.domain.entity.concretes.Privilege;
import edu.estu.estufastingrestapi.core.service.model.response.privilege.PrivilegeResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class PrivilegeResponseMapStructMapper implements MapStructMapper<Privilege, PrivilegeResponse> {
}
