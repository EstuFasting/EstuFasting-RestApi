package edu.estu.estufastingrestapi.core.domain.entity.listeners;

import edu.estu.estufastingrestapi.core.domain.constants.UserRole;
import edu.estu.estufastingrestapi.core.domain.entity.concretes.User;

import javax.persistence.PrePersist;
import java.util.Set;

public class UserCreateListener {

    @PrePersist
    public void prePersist(User target) {
        target.setRoles(Set.of(UserRole.getInstanceByName(UserRole.Name.USER)));
    }

}
