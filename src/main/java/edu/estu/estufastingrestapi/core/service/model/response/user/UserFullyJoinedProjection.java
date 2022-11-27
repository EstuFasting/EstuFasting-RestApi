package edu.estu.estufastingrestapi.core.service.model.response.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.estu.estufastingrestapi.core.service.model.abstraction.IdentifiableModel;
import edu.estu.estufastingrestapi.core.service.model.response.abstraction.CreationDateModel;
import edu.estu.estufastingrestapi.core.service.model.response.abstraction.ModificationDateModel;
import edu.estu.estufastingrestapi.core.service.model.response.language.LanguageQuickProjection;
import edu.estu.estufastingrestapi.core.service.model.response.role.RoleJoinedProjection;

import java.time.LocalDate;
import java.util.Collection;
import java.util.UUID;

public interface UserFullyJoinedProjection extends CreationDateModel, ModificationDateModel, IdentifiableModel<UUID> {

    String getUsername();

    String getEmail();

    String getPhoneNumber();

    LanguageQuickProjection getLanguage();

    String getFirstName();

    String getLastName();

    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate getBirthDate();

    Collection<RoleJoinedProjection> getRoles();

}
