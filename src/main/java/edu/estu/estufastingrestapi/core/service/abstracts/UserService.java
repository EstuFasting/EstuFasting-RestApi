package edu.estu.estufastingrestapi.core.service.abstracts;

import edu.estu.estufastingrestapi.core.domain.response.abstraction.ApiResponse;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.DeletableService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.EntityService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.ReadableService;
import edu.estu.estufastingrestapi.core.service.model.response.user.UserAuthProjection;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.time.LocalDate;
import java.util.UUID;

public interface UserService extends UserDetailsService, EntityService, ReadableService<String>, DeletableService<UUID> {

    String getPasswordByUsername(String username);

    @Override
    <P> ApiResponse getOneByProp(String username, Class<P> projection);

    UserAuthProjection getUserForLogin(String username);

    UserAuthProjection getUserAuthoritiesByUsername(String username);

    <P> ApiResponse getOneFullyJoinedByUsername(String username, Class<P> projection);

    ApiResponse deleteByUsername(String username);

    ApiResponse updateUsername(String username, String newUsername);

    ApiResponse updatePhoneNumber(String username, String phoneNumber);

    ApiResponse updateLanguage(String username, Integer languageId);

    ApiResponse updatePassword(String username, String password);

    ApiResponse updateFirstName(String username, String firstname);

    ApiResponse updateLastName(String username, String lastName);

    ApiResponse updateBirthDate(String username, LocalDate birthDate);

    ApiResponse updateEnabled(String username, Boolean enabled);
}
