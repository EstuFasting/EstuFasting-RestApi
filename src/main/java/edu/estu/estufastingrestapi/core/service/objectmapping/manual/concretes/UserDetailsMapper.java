package edu.estu.estufastingrestapi.core.service.objectmapping.manual.concretes;

import edu.estu.estufastingrestapi.core.domain.entity.concretes.User;
import edu.estu.estufastingrestapi.core.service.objectmapping.manual.abstracts.ManualMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDetailsMapper implements ManualMapper<User, org.springframework.security.core.userdetails.User> {

    private final GrantedAuthorityMapper grantedAuthorityMapper;

    @Override
    public org.springframework.security.core.userdetails.User map(User user) {
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getEnabled() == '1' || user.getEnabled() == null,
                true,
                true,
                true,
                grantedAuthorityMapper.map(user.getRoles())
        );

    }

}
