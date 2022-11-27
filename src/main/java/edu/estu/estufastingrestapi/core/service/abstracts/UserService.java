package edu.estu.estufastingrestapi.core.service.abstracts;

import edu.estu.estufastingrestapi.core.domain.entity.concretes.User;
import edu.estu.estufastingrestapi.core.domain.response.abstraction.ApiResponse;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.DeletableService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.EntityService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.ReadableService;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.UUID;

public interface UserService extends UserDetailsService, EntityService, ReadableService<UUID>, DeletableService<UUID> {

    String getPasswordByUsername(String username);

    User getUserForLogin(String username);

    <P> ApiResponse getFullyJoinedById(UUID id, Class<P> projection);

    <P> ApiResponse getFullyJoinedByUsername(String username, Class<P> projection);

}
