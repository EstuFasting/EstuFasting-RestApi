package edu.estu.estufastingrestapi.core.service.model.response.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.estu.estufastingrestapi.core.service.model.response.abstraction.CreationDateModel;
import edu.estu.estufastingrestapi.core.service.model.response.abstraction.ModificationDateModel;
import edu.estu.estufastingrestapi.core.service.model.response.role.RoleJoinedProjection;

import java.time.LocalDate;
import java.util.Collection;

public interface UserAuthProjection extends CreationDateModel, ModificationDateModel {

    String getUsername();

    String getPhoneNumber();

    String getFirstName();

    String getLastName();

    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate getBirthDate();

    Collection<RoleJoinedProjection> getRoles();

}
