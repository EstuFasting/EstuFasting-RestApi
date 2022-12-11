package edu.estu.estufastingrestapi.service.model.response.dininghall;

import edu.estu.estufastingrestapi.core.service.model.abstraction.IdentifiableModel;

public interface DiningHallQuickProjection extends IdentifiableModel<Integer> {

    String getName();

    String getDescription();

    String getAddress();

    Double getLatitude();

    Double getLongitude();

    Integer getCapacity();

}
