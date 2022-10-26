package edu.estu.estufastingrestapi.core.repository.abstracts;

import edu.estu.estufastingrestapi.core.model.entities.abstracts.Identifiable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface JpaRepositoryAdapter<T extends Identifiable<ID>, ID> extends JpaRepository<T, ID> {
}
