package edu.estu.estufastingrestapi.core.service.objectmapping.manual.concretes;

import edu.estu.estufastingrestapi.core.domain.helper.ReflectionHelper;
import edu.estu.estufastingrestapi.core.service.objectmapping.abstraction.Mapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @implSpec Source collection should have String getName() and Collection getPrivileges() methods.
 * And also, the Collection getPrivileges() method of source collection should have String getName() method.
 */
@Component
public class GrantedAuthorityMapper implements Mapper<Collection<?>, List<GrantedAuthority>> {

    private static final short APPROXIMATE_AUTHORITY_COUNT_PER_ROLE = 4;

    @Override
    public List<GrantedAuthority> map(Collection<?> source) {
        if (source == null) return new ArrayList<>();
        List<GrantedAuthority> destination = new ArrayList<>(source.size() * APPROXIMATE_AUTHORITY_COUNT_PER_ROLE);
        for (Object roleObj : source) {
            String roleName = ReflectionHelper.getFieldValueByGetter(roleObj, "getName", String.class).orElse(null);
            Iterable<?> privileges = ReflectionHelper.getFieldValueByGetter(roleObj, "getPrivileges", Iterable.class).orElse(new ArrayList<>(0));
            destination.add(new SimpleGrantedAuthority(roleName));
            for (Object privilege : privileges) {
                String privName = ReflectionHelper.getFieldValueByGetter(privilege, "getName", String.class).orElse(null);
                destination.add(new SimpleGrantedAuthority(privName));
            }
        }
        return destination;
    }

}
