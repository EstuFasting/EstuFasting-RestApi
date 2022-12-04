package edu.estu.estufastingrestapi.service.abstracts;

import edu.estu.estufastingrestapi.core.domain.response.abstraction.ApiResponse;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.CreatableService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.EntityService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.ReadableService;
import edu.estu.estufastingrestapi.service.model.request.menuitem.MenuItemCreateRequestModel;

import java.util.UUID;

public interface MenuItemService extends EntityService, CreatableService<MenuItemCreateRequestModel>, ReadableService<UUID> {
    ApiResponse updateName(UUID id, String name);

    ApiResponse updateCalories(UUID id, Integer calories);
}
