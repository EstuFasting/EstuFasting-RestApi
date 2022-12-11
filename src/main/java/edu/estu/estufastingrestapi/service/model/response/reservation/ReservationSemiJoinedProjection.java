package edu.estu.estufastingrestapi.service.model.response.reservation;

import edu.estu.estufastingrestapi.core.service.model.abstraction.IdentifiableModel;
import edu.estu.estufastingrestapi.service.model.response.catering.CateringResponse;
import edu.estu.estufastingrestapi.service.model.response.customer.CustomerResponse;

import java.util.UUID;

public interface ReservationSemiJoinedProjection extends IdentifiableModel<UUID> {

    CustomerResponse getCustomer();

    CateringResponse getCatering();

    Boolean getPaid();

}
