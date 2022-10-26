package edu.estu.estufastingrestapi.core.repository.abstracts;

import edu.estu.estufastingrestapi.core.model.entities.concretes.Privilege;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrivilegeRepository extends JpaRepositoryAdapter<Privilege, Integer> {

    Optional<Privilege> findFirstByName(String name);

}
