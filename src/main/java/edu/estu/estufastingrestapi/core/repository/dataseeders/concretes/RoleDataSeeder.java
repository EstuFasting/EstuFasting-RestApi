package edu.estu.estufastingrestapi.core.repository.dataseeders.concretes;

import edu.estu.estufastingrestapi.core.domain.entity.concretes.Role;
import edu.estu.estufastingrestapi.core.domain.enumeration.UserRole;
import edu.estu.estufastingrestapi.core.repository.dataseeders.abstracts.BaseDataSeeder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoleDataSeeder extends BaseDataSeeder<Role, Integer> {

    private final PrivilegeDataSeeder privilegeDataSeeder;

    @Override
    public int getOrder() {
        return 20;
    }

    @Override
    public void setData() {
        data.add(new Role(UserRole.ROLE_SUPER_ADMIN.getId(), "ROLE_SUPER_ADMIN", "Access to everywhere", privilegeDataSeeder.getData()));
        data.add(new Role(UserRole.ROLE_SYSTEM_EMPLOYEE.getId(), "ROLE_SYSTEM_EMPLOYEE", "Non-critical system privileges", privilegeDataSeeder.getData()));
        data.add(new Role(UserRole.ROLE_USER.getId(), "ROLE_USER", "Access to everywhere", privilegeDataSeeder.getData()));
    }

}
