package edu.estu.estufastingrestapi.core.domain.entity.listeners;

import edu.estu.estufastingrestapi.core.domain.constants.RoleConst;
import edu.estu.estufastingrestapi.core.domain.entity.concretes.Role;
import edu.estu.estufastingrestapi.core.domain.entity.concretes.User;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;

public class UserListener {

    @PrePersist
    public void prePersist(User target) {
        ListenerHelper.addToRoles(target, RoleConst.Id.USER);
    }

    @PreRemove
    public void preRemove(User target) {
        for (Role role : target.getRoles())
            target.getRoles().remove(role);
    }

}
