package edu.estu.estufastingrestapi.core.service.abstracts;

import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.DeletableService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.EntityService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.ReadableService;
import edu.estu.estufastingrestapi.core.service.model.response.user.UserAuthProjection;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceDataResponse;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.time.LocalDate;
import java.util.UUID;

public interface UserService extends UserDetailsService, EntityService, ReadableService<String>, DeletableService<UUID> {

    String getPasswordByUsername(String username);

    @Override
    <P> ServiceDataResponse<P> getOneByIdentifier(String username, Class<P> projection);

    UserAuthProjection getUserForLogin(String username);

    UserAuthProjection getUserAuthoritiesByUsername(String username);

    <P> ServiceResponse getOneFullyJoinedByUsername(String username, Class<P> projection);

    ServiceResponse deleteByUsername(String username);

    ServiceResponse updateUsername(String username, String newUsername);

    ServiceResponse updatePhoneNumber(String username, String phoneNumber);

    ServiceResponse updateLanguage(String username, Integer languageId);

    ServiceResponse updatePassword(String username, String password);

    ServiceResponse updateFirstName(String username, String firstname);

    ServiceResponse updateLastName(String username, String lastName);

    ServiceResponse updateBirthDate(String username, LocalDate birthDate);

    ServiceResponse updateEnabled(String username, Boolean enabled);
}
