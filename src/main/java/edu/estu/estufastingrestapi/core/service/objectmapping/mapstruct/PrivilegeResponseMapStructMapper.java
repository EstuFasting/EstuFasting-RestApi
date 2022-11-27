package edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct;

import edu.estu.estufastingrestapi.core.domain.entity.concretes.Privilege;
import edu.estu.estufastingrestapi.core.repository.abstracts.PrivilegeRepository;
import edu.estu.estufastingrestapi.core.service.model.response.privilege.PrivilegeResponse;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
@Setter(onMethod = @__(@Autowired))
public abstract class PrivilegeResponseMapStructMapper implements MapStructMapper<Privilege, PrivilegeResponse> {

    private PrivilegeRepository privilegeRepository;

    public PrivilegeResponse map(Privilege privilege) {
        privilege = privilegeRepository.getReferenceById(privilege.getId());
        return new PrivilegeResponse(privilege.getId(), privilege.getName(), privilege.getDescription());
    }

}
