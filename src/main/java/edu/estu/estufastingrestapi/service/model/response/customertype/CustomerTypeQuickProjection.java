package edu.estu.estufastingrestapi.service.model.response.customertype;

import edu.estu.estufastingrestapi.core.service.model.abstraction.IdentifiableModel;

public interface CustomerTypeQuickProjection extends IdentifiableModel<Integer> {

    String getName();

    String getDescription();

}
