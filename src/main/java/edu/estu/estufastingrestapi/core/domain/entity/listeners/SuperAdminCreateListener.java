package edu.estu.estufastingrestapi.core.domain.entity.listeners;

import edu.estu.estufastingrestapi.core.domain.entity.abstracts.Identifiable;
import edu.estu.estufastingrestapi.core.domain.entity.concretes.Role;
import edu.estu.estufastingrestapi.core.domain.entity.concretes.SuperAdmin;
import edu.estu.estufastingrestapi.core.domain.enumeration.UserRole;

import javax.persistence.PrePersist;
import java.util.Set;

public class SuperAdminCreateListener {

    @PrePersist
    public void prePersist(SuperAdmin target) {
        target.setRoles(Set.of(Identifiable.getInstance(Role::new, UserRole.ROLE_SUPER_ADMIN.getId())));
    }

}
