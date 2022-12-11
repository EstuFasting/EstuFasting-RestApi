package edu.estu.estufastingrestapi.service.model.response.customer;

import edu.estu.estufastingrestapi.core.service.model.response.user.UserFullyJoinedProjection;
import edu.estu.estufastingrestapi.service.model.response.customertype.CustomerTypeQuickProjection;
import edu.estu.estufastingrestapi.service.model.response.reservation.ReservationSemiJoinedProjection;

import java.util.Collection;

public interface CustomerFullyJoinedProjection extends UserFullyJoinedProjection {

    String getTckn();

    String getCardNo();

    CustomerTypeQuickProjection getType();

    Collection<ReservationSemiJoinedProjection> getReservations();

}
