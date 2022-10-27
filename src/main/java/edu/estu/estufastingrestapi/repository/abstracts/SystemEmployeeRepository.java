package edu.estu.estufastingrestapi.repository.abstracts;

import edu.estu.estufastingrestapi.core.repository.abstracts.JpaRepositoryAdapter;
import edu.estu.estufastingrestapi.entities.SystemEmployee;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SystemEmployeeRepository extends JpaRepositoryAdapter<SystemEmployee, UUID> {
}