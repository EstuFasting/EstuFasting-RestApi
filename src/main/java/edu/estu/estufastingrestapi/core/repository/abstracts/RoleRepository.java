package edu.estu.estufastingrestapi.core.repository.abstracts;

import edu.estu.estufastingrestapi.core.domain.entity.concretes.Role;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepositoryAdapter<Role, Integer> {

    <P> Optional<P> findFirstByName(String name, Class<P> projection);

}
