package edu.estu.estufastingrestapi.core.api.security;

import edu.estu.estufastingrestapi.core.domain.helper.PrincipalHelper;
import org.springframework.stereotype.Component;

@Component
public class SecurityChecker {

    public boolean isLoggedInUser(String username) {
        return PrincipalHelper.getCurrentUsername().map(currUsername -> currUsername.equals(username)).orElse(false);
    }

}
