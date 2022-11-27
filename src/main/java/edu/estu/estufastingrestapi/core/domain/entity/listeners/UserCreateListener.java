package edu.estu.estufastingrestapi.core.domain.entity.listeners;

import edu.estu.estufastingrestapi.core.domain.entity.abstracts.Identifiable;
import edu.estu.estufastingrestapi.core.domain.entity.concretes.Role;
import edu.estu.estufastingrestapi.core.domain.entity.concretes.User;
import edu.estu.estufastingrestapi.core.domain.enumeration.UserRole;

import javax.persistence.PrePersist;
import java.util.Set;

public class UserCreateListener {

    @PrePersist
    public void prePersist(User target) {
        target.setRoles(Set.of(Identifiable.getInstance(Role::new, UserRole.ROLE_USER.getId())));
    }

}
