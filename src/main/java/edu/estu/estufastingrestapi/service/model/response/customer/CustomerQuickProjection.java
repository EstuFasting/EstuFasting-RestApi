package edu.estu.estufastingrestapi.service.model.response.customer;

import edu.estu.estufastingrestapi.core.service.model.response.user.UserFullyJoinedProjection;
import edu.estu.estufastingrestapi.service.model.response.customertype.CustomerTypeQuickProjection;

public interface CustomerQuickProjection extends UserFullyJoinedProjection {

    String getTckn();

    String getCardNo();

    CustomerTypeQuickProjection getType();

}
