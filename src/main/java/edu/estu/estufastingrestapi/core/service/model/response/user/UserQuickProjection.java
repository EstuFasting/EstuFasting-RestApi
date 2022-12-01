package edu.estu.estufastingrestapi.core.service.model.response.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.estu.estufastingrestapi.core.service.model.response.abstraction.CreationDateModel;
import edu.estu.estufastingrestapi.core.service.model.response.abstraction.ModificationDateModel;

import java.time.LocalDate;

public interface UserQuickProjection extends CreationDateModel, ModificationDateModel {

    String getUsername();

    String getPhoneNumber();

    String getFirstName();

    String getLastName();

    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate getBirthDate();

}
