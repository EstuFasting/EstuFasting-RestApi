package edu.estu.estufastingrestapi.core.domain.helper;

import lombok.experimental.UtilityClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@UtilityClass
public class PrincipalHelper {

    public static Optional<Object> getCurrentPrincipal() {
        return Optional.ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .map(Authentication::getPrincipal);
    }

    public static Optional<String> getCurrentUsername() {
        return ReflectionHelper.getFieldValueByGetter(getCurrentPrincipal().orElse(null), "getUsername", String.class);
    }

}
