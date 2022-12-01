package edu.estu.estufastingrestapi.core.service.objectmapping.manual.concretes;

import edu.estu.estufastingrestapi.core.service.objectmapping.abstraction.CollectionMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class AuthorityNameMapper implements CollectionMapper<GrantedAuthority, String> {

    @Override
    public String map(GrantedAuthority source) {
        return source.getAuthority();
    }

}
