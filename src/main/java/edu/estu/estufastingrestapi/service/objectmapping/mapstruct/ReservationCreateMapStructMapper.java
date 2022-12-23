package edu.estu.estufastingrestapi.service.objectmapping.mapstruct;

import edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct.MapStructMapper;
import edu.estu.estufastingrestapi.entities.concretes.Reservation;
import edu.estu.estufastingrestapi.service.model.request.reservation.ReservationCreateRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public abstract class ReservationCreateMapStructMapper implements MapStructMapper<ReservationCreateRequestModel, Reservation> {

    @Mapping(target = "catering.id", source = "source.cateringId")
    @Mapping(target = "customer.id", source = "source.customerId")
    public abstract Reservation map(ReservationCreateRequestModel source);

    @Mapping(target = "catering.id", source = "source.cateringId")
    @Mapping(target = "customer.id", source = "source.customerId")
    public abstract Reservation mapInto(ReservationCreateRequestModel source, @MappingTarget Reservation destination);

    @Mapping(target = "cateringId", source = "destination.catering.id")
    @Mapping(target = "customerId", source = "destination.customer.id")
    public abstract ReservationCreateRequestModel mapReverse(Reservation destination);

}
