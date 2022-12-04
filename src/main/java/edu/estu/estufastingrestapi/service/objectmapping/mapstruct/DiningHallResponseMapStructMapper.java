package edu.estu.estufastingrestapi.service.objectmapping.mapstruct;

import edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct.MapStructMapper;
import edu.estu.estufastingrestapi.entities.concretes.DiningHall;
import edu.estu.estufastingrestapi.service.model.response.dininghall.DiningHallResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class DiningHallResponseMapStructMapper implements MapStructMapper<DiningHall, DiningHallResponse> {
}
