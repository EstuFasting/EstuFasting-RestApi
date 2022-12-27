package edu.estu.estufastingrestapi.core.domain.helper;

import edu.estu.estufastingrestapi.core.service.objectmapping.manual.concretes.AuthorityNameMapper;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@UtilityClass
public class SecurityStaticHelper {

    private static final AuthorityNameMapper authorityNameMapper = BeanHelper.getBean(AuthorityNameMapper.class);

    public static Optional<Authentication> getAuthentication() {
        return Optional.ofNullable(SecurityContextHolder.getContext()).map(SecurityContext::getAuthentication);
    }

    public static Optional<Object> getPrincipal() {
        return getAuthentication().map(Authentication::getPrincipal);
    }

    public static Optional<String> getUsername() {
        return ReflectionHelper.getFieldValueByGetter(getPrincipal().orElse(null), "getUsername", String.class);
    }

    public static List<String> getAuthorities() {
        Optional<Authentication> authentication = SecurityStaticHelper.getAuthentication();
        if (authentication.isEmpty()) return Collections.emptyList();
        return authorityNameMapper.mapCollection(authentication.get().getAuthorities());
    }

}
