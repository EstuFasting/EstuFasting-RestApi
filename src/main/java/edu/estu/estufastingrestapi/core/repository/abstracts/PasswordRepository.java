package edu.estu.estufastingrestapi.core.repository.abstracts;

import edu.estu.estufastingrestapi.core.model.entities.concretes.Password;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PasswordRepository extends JpaRepositoryAdapter<Password, UUID> {
}
