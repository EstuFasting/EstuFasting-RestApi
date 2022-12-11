package edu.estu.estufastingrestapi.service.abstracts;

import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.CreatableService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.EntityService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.ReadableService;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceResponse;
import edu.estu.estufastingrestapi.service.model.request.menuitem.MenuItemCreateRequestModel;

import java.util.UUID;

public interface MenuItemService extends EntityService, CreatableService<MenuItemCreateRequestModel>, ReadableService<UUID> {

    ServiceResponse updateName(UUID id, String name);

    ServiceResponse updateCalories(UUID id, Integer calories);

}
