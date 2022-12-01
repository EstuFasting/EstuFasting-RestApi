package edu.estu.estufastingrestapi.core.domain.entity.listeners;

import edu.estu.estufastingrestapi.core.domain.constants.UserRole;
import edu.estu.estufastingrestapi.core.domain.entity.concretes.SuperAdmin;

import javax.persistence.PrePersist;
import java.util.Set;

public class SuperAdminListener {

    @PrePersist
    public void prePersist(SuperAdmin target) {
        target.setRoles(Set.of(UserRole.getInstanceByName(UserRole.Name.SUPER_ADMIN)));
    }

}
