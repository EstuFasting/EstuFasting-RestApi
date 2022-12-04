package edu.estu.estufastingrestapi.core.repository.dataseeders.concretes;

import edu.estu.estufastingrestapi.core.domain.constants.RoleConst;
import edu.estu.estufastingrestapi.core.domain.entity.concretes.Role;
import edu.estu.estufastingrestapi.core.repository.dataseeders.abstracts.BaseDataSeeder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoleDataSeeder extends BaseDataSeeder<Role, Integer> {

    @Override
    public int getOrder() {
        return 20;
    }

    @Override
    public void setData() {
        data.addAll(RoleConst.roles().stream().toList());
    }

}
