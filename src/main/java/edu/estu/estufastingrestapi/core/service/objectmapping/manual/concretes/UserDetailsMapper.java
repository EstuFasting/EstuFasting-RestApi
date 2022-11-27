package edu.estu.estufastingrestapi.core.service.objectmapping.manual.concretes;

import edu.estu.estufastingrestapi.core.domain.entity.concretes.User;
import edu.estu.estufastingrestapi.core.service.objectmapping.manual.abstracts.ManualMapper;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsMapper implements ManualMapper<User, org.springframework.security.core.userdetails.User> {

    @Override
    public org.springframework.security.core.userdetails.User map(User user) {
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getEnabled() == '1' || user.getEnabled() == null,
                user.getAccountNonExpired() == '1' || user.getAccountNonExpired() == null,
                user.getCredentialsNonExpired() == '1' || user.getCredentialsNonExpired() == null,
                user.getAccountNonLocked() == '1' || user.getAccountNonLocked() == null,
                user.getAuthorities()
        );

    }

}
