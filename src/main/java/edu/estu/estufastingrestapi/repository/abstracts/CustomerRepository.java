package edu.estu.estufastingrestapi.repository.abstracts;

import edu.estu.estufastingrestapi.core.repository.abstracts.JpaRepositoryAdapter;
import edu.estu.estufastingrestapi.core.service.model.response.user.UserAuthProjection;
import edu.estu.estufastingrestapi.entities.concretes.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepositoryAdapter<Customer, UUID> {

    @Query(value = """
                select c.password from Customer c
                where c.tckn = :tckn
            """)
    String findPasswordByTckn(@Param("tckn") String tckn);

    @Query(value = """
                select u from Customer u
                where u.tckn = :tckn
            """)
    <P> Optional<P> findQuickByTckn(String tckn, Class<P> projection);

    @Query(value = """
                select u from Customer u
                left join fetch u.language l
                left join fetch u.roles r
                left join fetch r.privileges p
                left join fetch u.reservations res
                left join fetch res.catering c
                where u.username = :username
            """)
    <P> Optional<P> findFullyJoinedByUsername(String username, Class<P> projection);

    @Query(value = """
                select c from Customer c
                left join fetch c.language l
                left join fetch c.roles r
                left join fetch r.privileges p
                where c.tckn = :tckn
            """)
    Optional<UserAuthProjection> findByUsernameForLogin(@Param("tckn") String tckn);

    @Modifying
    @Query("update Customer c set c.type.id = :customerTypeId where c.id = :id")
    int updateType(UUID id, Integer customerTypeId);

}
