package edu.estu.estufastingrestapi.service.model.response.menuitem;

import edu.estu.estufastingrestapi.core.service.model.abstraction.IdentifiableModel;

import java.util.UUID;

public interface MenuItemQuickProjection extends IdentifiableModel<UUID> {

    String getName();

    Integer getCalories();

}
