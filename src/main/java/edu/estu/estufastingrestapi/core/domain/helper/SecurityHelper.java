package edu.estu.estufastingrestapi.core.domain.helper;

import edu.estu.estufastingrestapi.core.service.objectmapping.manual.concretes.AuthorityNameMapper;
import edu.estu.estufastingrestapi.core.service.objectmapping.manual.concretes.GrantedAuthorityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@RequiredArgsConstructor
public class SecurityHelper {

    private final AuthorityNameMapper authorityNameMapper;

    public boolean isLoggedInUser(String username) {
        return SecurityStaticHelper.getUsername().map(currUsername -> currUsername.equals(username)).orElse(false);
    }

    public boolean isLoggedInUser(List<String> usernames) {
        if (usernames == null || usernames.isEmpty() || new HashSet<>(usernames).size() > 1) return false;
        return isLoggedInUser(usernames.get(0));
    }

    public Optional<String> getCurrentUsername() {
        return SecurityStaticHelper.getUsername();
    }

    public List<String> getAuthorities() {
        return SecurityStaticHelper.getAuthorities();
    }

}
