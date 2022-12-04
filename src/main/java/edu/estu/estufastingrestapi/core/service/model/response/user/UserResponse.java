package edu.estu.estufastingrestapi.core.service.model.response.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.estu.estufastingrestapi.core.service.model.response.abstraction.AuditedResponse;
import edu.estu.estufastingrestapi.core.service.model.response.language.LanguageResponse;
import edu.estu.estufastingrestapi.core.service.model.response.role.RoleResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse extends AuditedResponse {

    private UUID id;

    private String username;

    private String phoneNumber;

    private LanguageResponse language;

    private String firstName;

    private String lastName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    private Set<RoleResponse> roles;

}
