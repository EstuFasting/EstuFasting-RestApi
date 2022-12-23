package edu.estu.estufastingrestapi.core.domain.helper;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Component
public class SecurityHelper {

    public boolean isLoggedInUser(String username) {
        return getCurrentUsername().map(currUsername -> currUsername.equals(username)).orElse(false);
    }

    public boolean isLoggedInUser(List<String> usernames) {
        if (usernames == null || usernames.isEmpty() || new HashSet<>(usernames).size() > 1) return false;
        return isLoggedInUser(usernames.get(0));
    }

    public Optional<Object> getCurrentPrincipal() {
        return SecurityStaticHelper.getCurrentPrincipal();
    }

    public static Optional<String> getCurrentUsername() {
        return SecurityStaticHelper.getCurrentUsername();
    }

}
