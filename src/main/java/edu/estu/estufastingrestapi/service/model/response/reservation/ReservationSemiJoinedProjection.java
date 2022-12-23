package edu.estu.estufastingrestapi.service.model.response.reservation;

import edu.estu.estufastingrestapi.core.service.model.abstraction.IdentifiableModel;
import edu.estu.estufastingrestapi.service.model.response.catering.CateringQuickProjection;

import java.util.UUID;

public interface ReservationSemiJoinedProjection extends IdentifiableModel<UUID> {

    CateringQuickProjection getCatering();

    Boolean getPaid();

}
