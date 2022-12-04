package edu.estu.estufastingrestapi.service.objectmapping.mapstruct;

import edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct.MapStructMapper;
import edu.estu.estufastingrestapi.entities.concretes.Catering;
import edu.estu.estufastingrestapi.service.model.response.catering.CateringResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {MealResponseMapStructMapper.class, MenuItemResponseMapStructMapper.class})
public abstract class CateringResponseMapStructMapper implements MapStructMapper<Catering, CateringResponse> {
}
