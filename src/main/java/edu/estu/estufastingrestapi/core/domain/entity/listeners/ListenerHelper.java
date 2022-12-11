package edu.estu.estufastingrestapi.core.domain.entity.listeners;

import edu.estu.estufastingrestapi.core.domain.constants.RoleConst;
import edu.estu.estufastingrestapi.core.domain.entity.concretes.Role;
import edu.estu.estufastingrestapi.core.domain.entity.concretes.User;
import lombok.experimental.UtilityClass;

import java.util.HashSet;
import java.util.Set;

@UtilityClass
public class ListenerHelper {

    public void addToRoles(User user, Integer roleId) {
        Role role = RoleConst.getInstanceById(roleId);
        if (user.getRoles() == null) {
            Set<Role> roles = new HashSet<>();
            roles.add(role);
            user.setRoles(roles);
        } else user.getRoles().add(role);
    }

}
