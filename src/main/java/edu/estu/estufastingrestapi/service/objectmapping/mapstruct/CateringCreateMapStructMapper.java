package edu.estu.estufastingrestapi.service.objectmapping.mapstruct;

import edu.estu.estufastingrestapi.core.service.objectmapping.MappingHelper;
import edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct.MapStructMapper;
import edu.estu.estufastingrestapi.entities.concretes.Catering;
import edu.estu.estufastingrestapi.entities.concretes.MenuItem;
import edu.estu.estufastingrestapi.service.model.request.catering.CateringCreateRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", imports = {MenuItem.class, MappingHelper.class})
public abstract class CateringCreateMapStructMapper implements MapStructMapper<CateringCreateRequestModel, Catering> {

    @Mapping(target = "meal.id", source = "source.mealId")
    @Mapping(target = "menuItems", expression = "java(MappingHelper.mapFromIdList(source.getMenuItemIds(), edu.estu.estufastingrestapi.entities.concretes.MenuItem::new))")
    public abstract Catering map(CateringCreateRequestModel source);

    @Mapping(target = "meal.id", source = "source.mealId")
    @Mapping(target = "menuItems", expression = "java(MappingHelper.mapFromIdList(source.getMenuItemIds(), MenuItem::new))")
    public abstract Catering mapInto(CateringCreateRequestModel source, @MappingTarget Catering destination);

    @Mapping(target = "mealId", source = "destination.meal.id")
    public abstract CateringCreateRequestModel mapReverse(Catering destination);

}
