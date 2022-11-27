package edu.estu.estufastingrestapi.core.repository.abstracts;

import edu.estu.estufastingrestapi.core.domain.entity.concretes.Privilege;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrivilegeRepository extends JpaRepositoryAdapter<Privilege, Integer> {

    <P> Optional<P> findFirstByName(String name, Class<P> projection);

}
