package edu.estu.estufastingrestapi.service.objectmapping.mapstruct;

import edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct.MapStructMapper;
import edu.estu.estufastingrestapi.entities.concretes.MenuItem;
import edu.estu.estufastingrestapi.service.model.response.menuitem.MenuItemResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class MenuItemResponseMapStructMapper implements MapStructMapper<MenuItem, MenuItemResponse> {
}