package edu.estu.estufastingrestapi.core.service.model.response.language;

import edu.estu.estufastingrestapi.core.service.model.abstraction.IdentifiableModel;

public interface LanguageQuickProjection extends IdentifiableModel<Integer> {

    String getName();

    String getLocalName();

    String getAlpha2();

    String getAlpha3T();

    Boolean getUnlisted();

    Boolean getSupported();

}
