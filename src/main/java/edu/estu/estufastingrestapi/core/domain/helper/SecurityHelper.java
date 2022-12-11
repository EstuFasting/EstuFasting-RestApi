package edu.estu.estufastingrestapi.core.domain.helper;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SecurityHelper {

    public boolean isLoggedInUser(String username) {
        return getCurrentUsername().map(currUsername -> currUsername.equals(username)).orElse(false);
    }

    public Optional<Object> getCurrentPrincipal() {
        return SecurityStaticHelper.getCurrentPrincipal();
    }

    public static Optional<String> getCurrentUsername() {
        return SecurityStaticHelper.getCurrentUsername();
    }

}
