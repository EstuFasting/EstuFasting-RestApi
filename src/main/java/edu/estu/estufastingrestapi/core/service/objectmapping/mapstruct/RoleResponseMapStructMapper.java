package edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct;

import edu.estu.estufastingrestapi.core.domain.entity.concretes.Role;
import edu.estu.estufastingrestapi.core.repository.abstracts.RoleRepository;
import edu.estu.estufastingrestapi.core.service.model.response.role.RoleResponse;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
@Setter(onMethod = @__(@Autowired))
public abstract class RoleResponseMapStructMapper implements MapStructMapper<Role, RoleResponse> {

    private RoleRepository roleRepository;
    private PrivilegeResponseMapStructMapper privilegeMapper;

    public RoleResponse map(Role role) {
        role = roleRepository.getReferenceById(role.getId());
        return new RoleResponse(role.getId(), role.getName(), role.getDescription(), privilegeMapper.mapCollection(role.getPrivileges()));
    }

}
