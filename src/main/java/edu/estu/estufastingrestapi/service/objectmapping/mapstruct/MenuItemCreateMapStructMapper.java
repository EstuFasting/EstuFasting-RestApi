package edu.estu.estufastingrestapi.service.objectmapping.mapstruct;

import edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct.MapStructMapper;
import edu.estu.estufastingrestapi.entities.concretes.MenuItem;
import edu.estu.estufastingrestapi.service.model.request.menuitem.MenuItemCreateRequestModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class MenuItemCreateMapStructMapper implements MapStructMapper<MenuItemCreateRequestModel, MenuItem> {
}
