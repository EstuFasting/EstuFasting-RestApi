package edu.estu.estufastingrestapi.service.model.response.customer;

import edu.estu.estufastingrestapi.core.service.model.response.user.UserFullyJoinedProjection;
import edu.estu.estufastingrestapi.service.model.response.catering.CateringQuickProjection;
import edu.estu.estufastingrestapi.service.model.response.customertype.CustomerTypeQuickProjection;

import java.util.Collection;

public interface CustomerFullyJoinedProjection extends UserFullyJoinedProjection {

    String getTckn();

    String getCardNo();

    CustomerTypeQuickProjection getType();

    Collection<CateringQuickProjection> getReservations();

}
