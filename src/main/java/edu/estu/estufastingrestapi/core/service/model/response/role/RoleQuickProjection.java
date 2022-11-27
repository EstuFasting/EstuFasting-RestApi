package edu.estu.estufastingrestapi.core.service.model.response.role;

import edu.estu.estufastingrestapi.core.service.model.abstraction.IdentifiableModel;

public interface RoleQuickProjection extends IdentifiableModel<Integer> {

    String getName();

    String getDescription();

}
