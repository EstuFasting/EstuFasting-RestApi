package edu.estu.estufastingrestapi.core.model.dto.role;

import edu.estu.estufastingrestapi.core.model.dto.abstraction.CreationDateDto;
import edu.estu.estufastingrestapi.core.model.dto.abstraction.IdentifiableDto;
import edu.estu.estufastingrestapi.core.model.dto.abstraction.ModificationDateDto;
import edu.estu.estufastingrestapi.core.model.dto.privilege.PrivilegeGetDto;

import java.util.Collection;

public interface RoleGetDto extends CreationDateDto, ModificationDateDto, IdentifiableDto<Integer> {

    String getName();

    String getDescription();

    Collection<PrivilegeGetDto> getPrivileges();

}
