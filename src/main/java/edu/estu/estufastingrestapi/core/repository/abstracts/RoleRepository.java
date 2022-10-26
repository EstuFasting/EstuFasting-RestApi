package edu.estu.estufastingrestapi.core.repository.abstracts;

import edu.estu.estufastingrestapi.core.model.entities.concretes.Role;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepositoryAdapter<Role, Integer> {

    Optional<Role> findFirstByName(String name);

}
