package edu.estu.estufastingrestapi.core.service.abstracts;

import edu.estu.estufastingrestapi.core.model.dto.superadmin.SuperAdminCreateDto;
import edu.estu.estufastingrestapi.core.model.dto.superadmin.SuperAdminUpdateDto;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.*;

import java.util.UUID;

public interface SuperAdminService extends EntityService, CreatableService<SuperAdminCreateDto>, ReadableService, UpdatableService<SuperAdminUpdateDto>, DeletableService<UUID>, SoftDeletableService {
}
