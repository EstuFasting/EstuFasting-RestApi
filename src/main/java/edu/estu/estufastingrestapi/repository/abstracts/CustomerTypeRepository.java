package edu.estu.estufastingrestapi.repository.abstracts;

import edu.estu.estufastingrestapi.core.repository.abstracts.JpaRepositoryAdapter;
import edu.estu.estufastingrestapi.model.entities.CustomerType;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerTypeRepository extends JpaRepositoryAdapter<CustomerType, Integer> {
}
