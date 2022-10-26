package edu.estu.estufastingrestapi.core.repository.abstracts;

import edu.estu.estufastingrestapi.core.model.entities.concretes.SuperAdmin;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SuperAdminRepository extends JpaRepositoryAdapter<SuperAdmin, UUID> {
}
