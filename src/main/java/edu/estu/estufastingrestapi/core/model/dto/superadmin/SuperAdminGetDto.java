package edu.estu.estufastingrestapi.core.model.dto.superadmin;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.estu.estufastingrestapi.core.model.dto.abstraction.CreationDateDto;
import edu.estu.estufastingrestapi.core.model.dto.abstraction.IdentifiableDto;
import edu.estu.estufastingrestapi.core.model.dto.abstraction.ModificationDateDto;
import edu.estu.estufastingrestapi.core.model.dto.language.LanguageGetDto;
import edu.estu.estufastingrestapi.core.model.dto.role.RoleGetDto;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface SuperAdminGetDto extends CreationDateDto, ModificationDateDto, IdentifiableDto<UUID> {

    String getUsername();

    String getEmail();

    String getPhoneNumber();

    LanguageGetDto getLanguage();

    String getFirstName();

    String getLastName();

    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate getBirthDate();

    boolean getEnabled();

    boolean getAccountNonLocked();

    boolean getAccountNonExpired();

    boolean getCredentialsNonExpired();

    List<RoleGetDto> getRoles();

}
