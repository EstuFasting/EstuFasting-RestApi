package edu.estu.estufastingrestapi.core.repository.abstracts;

import edu.estu.estufastingrestapi.core.domain.entity.abstracts.Identifiable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface JpaRepositoryAdapter<T extends Identifiable<ID>, ID> extends JpaRepository<T, ID> {

    <P> Optional<P> findById(ID id, Class<P> projection);

    <P> Page<P> findAllBy(Pageable pageable, Class<P> projection);

}
