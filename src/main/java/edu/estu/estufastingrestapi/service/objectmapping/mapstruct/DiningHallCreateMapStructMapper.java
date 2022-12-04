package edu.estu.estufastingrestapi.service.objectmapping.mapstruct;

import edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct.MapStructMapper;
import edu.estu.estufastingrestapi.entities.concretes.DiningHall;
import edu.estu.estufastingrestapi.service.model.request.dininghall.DiningHallCreateRequestModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class DiningHallCreateMapStructMapper implements MapStructMapper<DiningHallCreateRequestModel, DiningHall> {
}


