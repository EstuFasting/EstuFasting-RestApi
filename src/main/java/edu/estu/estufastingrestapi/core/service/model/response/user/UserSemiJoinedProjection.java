package edu.estu.estufastingrestapi.core.service.model.response.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.estu.estufastingrestapi.core.service.model.response.abstraction.CreationDateModel;
import edu.estu.estufastingrestapi.core.service.model.response.abstraction.ModificationDateModel;
import edu.estu.estufastingrestapi.core.service.model.response.language.LanguageQuickProjection;

import java.time.LocalDate;

public interface UserSemiJoinedProjection extends CreationDateModel, ModificationDateModel {

    String getUsername();

    String getPhoneNumber();

    LanguageQuickProjection getLanguage();

    String getFirstName();

    String getLastName();

    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate getBirthDate();

}
