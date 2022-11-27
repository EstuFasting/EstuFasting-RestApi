package edu.estu.estufastingrestapi.core.service.model.response.role;

import edu.estu.estufastingrestapi.core.service.model.abstraction.IdentifiableModel;
import edu.estu.estufastingrestapi.core.service.model.response.privilege.PrivilegeQuickProjection;

import java.util.Collection;

public interface RoleJoinedProjection extends IdentifiableModel<Integer> {

    String getName();

    String getDescription();

    Collection<PrivilegeQuickProjection> getPrivileges();

}
