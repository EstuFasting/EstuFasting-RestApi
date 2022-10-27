package edu.estu.estufastingrestapi.core.repository.initialdataloaders.concretes;

import edu.estu.estufastingrestapi.core.model.entities.concretes.Privilege;
import edu.estu.estufastingrestapi.core.repository.initialdataloaders.abstracts.BaseInitialDataLoader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class PrivilegeInitialDataLoader extends BaseInitialDataLoader<Privilege, Integer> {

    private final EntityManager entityManager;

    @Override
    public int getOrder() {
        return 10;
    }

    @Override
    public Collection<Privilege> getData() {
        if (this.data != null) return this.data;
        Collection<Privilege> data = new ArrayList<>();

        Metamodel metamodel = entityManager.getMetamodel();
        Set<EntityType<?>> entities = metamodel.getEntities();

        entities.forEach(e -> {
            data.add(new Privilege(null, "C_" + e.getName(), "c_" + e.getName().toLowerCase()));
            data.add(new Privilege(null, "R_" + e.getName(), "r_" + e.getName().toLowerCase()));
            data.add(new Privilege(null, "U_" + e.getName(), "u_" + e.getName().toLowerCase()));
            data.add(new Privilege(null, "D_" + e.getName(), "d_" + e.getName().toLowerCase()));
        });

        this.data = data;
        return this.data;
    }

}
