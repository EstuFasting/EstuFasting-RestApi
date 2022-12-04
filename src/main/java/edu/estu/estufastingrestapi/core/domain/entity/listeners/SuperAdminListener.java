package edu.estu.estufastingrestapi.core.domain.entity.listeners;

import edu.estu.estufastingrestapi.core.domain.constants.RoleConst;
import edu.estu.estufastingrestapi.core.domain.entity.concretes.SuperAdmin;

import javax.persistence.PrePersist;

public class SuperAdminListener {

    @PrePersist
    public void prePersist(SuperAdmin target) {
        ListenerHelper.addToRoles(target, RoleConst.Name.SUPER_ADMIN);
        ListenerHelper.addToRoles(target, RoleConst.Name.CUSTOMER);
        ListenerHelper.addToRoles(target, RoleConst.Name.STAFF);
    }

}
