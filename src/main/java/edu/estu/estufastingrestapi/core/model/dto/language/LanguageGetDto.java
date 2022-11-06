package edu.estu.estufastingrestapi.core.model.dto.language;

import edu.estu.estufastingrestapi.core.model.dto.abstraction.CreationDateDto;
import edu.estu.estufastingrestapi.core.model.dto.abstraction.IdentifiableDto;
import edu.estu.estufastingrestapi.core.model.dto.abstraction.ModificationDateDto;

public interface LanguageGetDto extends CreationDateDto, ModificationDateDto, IdentifiableDto<Integer> {

    String getName();

    String getLocalName();

    String getAlpha2();

    String getAlpha3T();

    Boolean getUnlisted();

    Boolean getSupported();

}
