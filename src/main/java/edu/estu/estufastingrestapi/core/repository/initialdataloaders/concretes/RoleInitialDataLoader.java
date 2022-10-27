package edu.estu.estufastingrestapi.core.repository.initialdataloaders.concretes;

import edu.estu.estufastingrestapi.core.model.entities.concretes.Role;
import edu.estu.estufastingrestapi.core.repository.abstracts.PrivilegeRepository;
import edu.estu.estufastingrestapi.core.repository.initialdataloaders.abstracts.BaseInitialDataLoader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
@RequiredArgsConstructor
public class RoleInitialDataLoader extends BaseInitialDataLoader<Role, Integer> {

    private final PrivilegeRepository privilegeRepository;

    @Override
    public int getOrder() {
        return 20;
    }

    @Override
    public Collection<Role> getData() {
        if (this.data != null) return this.data;
        Collection<Role> data = new ArrayList<>();

        data.add(new Role(null, "ROLE_SUPER_ADMIN", "Access to everywhere", privilegeRepository.findAll()));
        data.add(new Role(null, "ROLE_SYSTEM_EMPLOYEE", "Non-critical system privileges", privilegeRepository.findAll()));
        data.add(new Role(null, "ROLE_USER", "Access to everywhere", privilegeRepository.findAll()));

        this.data = data;
        return this.data;
    }

}
