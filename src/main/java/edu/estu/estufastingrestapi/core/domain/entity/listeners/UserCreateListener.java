package edu.estu.estufastingrestapi.core.domain.entity.listeners;

import edu.estu.estufastingrestapi.core.domain.constants.RoleConst;
import edu.estu.estufastingrestapi.core.domain.entity.concretes.User;

import javax.persistence.PrePersist;

public class UserCreateListener {

    @PrePersist
    public void prePersist(User target) {
        ListenerHelper.addToRoles(target, RoleConst.Name.USER);
    }

}
