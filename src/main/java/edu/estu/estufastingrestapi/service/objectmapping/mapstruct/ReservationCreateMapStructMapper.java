package edu.estu.estufastingrestapi.service.objectmapping.mapstruct;

import edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct.MapStructMapper;
import edu.estu.estufastingrestapi.entities.concretes.Reservation;
import edu.estu.estufastingrestapi.service.model.request.reservation.ReservationCreateRequestModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ReservationCreateMapStructMapper implements MapStructMapper<ReservationCreateRequestModel, Reservation> {
}
