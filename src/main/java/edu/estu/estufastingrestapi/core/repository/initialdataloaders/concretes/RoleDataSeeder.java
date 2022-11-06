package edu.estu.estufastingrestapi.core.repository.initialdataloaders.concretes;

import edu.estu.estufastingrestapi.core.model.entities.concretes.Role;
import edu.estu.estufastingrestapi.core.repository.abstracts.PrivilegeRepository;
import edu.estu.estufastingrestapi.core.repository.initialdataloaders.abstracts.BaseDataSeeder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoleDataSeeder extends BaseDataSeeder<Role, Integer> {

    private final PrivilegeRepository privilegeRepository;

    @Override
    public int getOrder() {
        return 20;
    }

    @Override
    public void setData() {
        data.add(new Role(null, "ROLE_SUPER_ADMIN", "Access to everywhere", privilegeRepository.findAll()));
        data.add(new Role(null, "ROLE_SYSTEM_EMPLOYEE", "Non-critical system privileges", privilegeRepository.findAll()));
        data.add(new Role(null, "ROLE_USER", "Access to everywhere", privilegeRepository.findAll()));
    }

}
