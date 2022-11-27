package edu.estu.estufastingrestapi.core.repository.abstracts;

import edu.estu.estufastingrestapi.core.domain.entity.concretes.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepositoryAdapter<User, UUID> {

    @Query(value = """
                select s.password from User s
                where s.username = :username
            """)
    String findPasswordByUsername(@Param("username") String username);

    @Query(value = """
                select s from User s
                left join fetch s.language l
                left join fetch s.roles r
                left join r.privileges p
                where s.id = :id
            """)
    <P> Optional<P> findFullyJoinedById(@Param("id") UUID id, Class<P> projection);

    @Query(value = """
                select s from User s
                left join fetch s.language l
                left join fetch s.roles r
                left join fetch r.privileges p
                where s.username = :username
            """)
    <P> Optional<P> findFullyJoinedByUsername(@Param("username") String username, Class<P> projection);

    @Query(value = """
                select s from User s
                left join s.roles r
                left join r.privileges p
                where s.username = :username
            """)
    <P> Optional<P> findByUsernameForSecurity(String username, Class<P> projection);

    <P> Optional<P> findFirstByUsername(String username, Class<P> projection);

    <P> Optional<P> findFirstByEmail(String email, Class<P> projection);

    <P> Optional<P> findFirstByPhoneNumber(String phoneNumber, Class<P> projection);

    @Modifying
    @Query("update User u set u.username = :username where u.id = :id")
    int updateUserName(@Param("id") Integer id, @Param("username") String username);

    @Modifying
    @Query("update User u set u.email = :email where u.id = :id")
    int updateEmail(@Param("id") Integer id, @Param("email") String email);

    @Modifying
    @Query("update User u set u.phoneNumber = :phoneNumber where u.id = :id")
    int updatePhoneNumber(@Param("id") Integer id, @Param("phoneNumber") String phoneNumber);

    @Modifying
    @Query("update User u set u.language.id = :languageId where u.id = :id")
    int updateLanguage(@Param("id") Integer id, @Param("languageId") Integer languageId);

    @Modifying
    @Query("update User u set u.password = :password where u.id = :id")
    int updatePassword(@Param("id") Integer id, @Param("password") String password);

    @Modifying
    @Query("update User u set u.firstName = :firstName where u.id = :id")
    int updateFirstName(@Param("id") Integer id, @Param("firstName") String firstName);

    @Modifying
    @Query("update User u set u.lastName = :lastName where u.id = :id")
    int updateLastName(@Param("id") Integer id, @Param("lastName") String lastName);

    @Modifying
    @Query("update User u set u.birthDate = :birthDate where u.id = :id")
    int updateBirthDate(@Param("id") Integer id, @Param("birthDate") LocalDate birthDate);

    @Modifying
    @Query("update User u set u.enabled = :enabled where u.id = :id")
    int updateEnabled(@Param("id") Integer id, @Param("enabled") Boolean enabled);

    @Modifying
    @Query("update User u set u.accountNonLocked = :accountNonLocked where u.id = :id")
    int updateAccountNonLocked(@Param("id") Integer id, @Param("accountNonLocked") Character accountNonLocked);

    @Modifying
    @Query("update User u set u.accountNonExpired = :accountNonExpired where u.id = :id")
    int updateAccountNonExpired(@Param("id") Integer id, @Param("accountNonExpired") Boolean accountNonExpired);

    @Modifying
    @Query("update User u set u.credentialsNonExpired = :credentialsNonExpired where u.id = :id")
    int updateCredentialsNonExpired(@Param("id") Integer id, @Param("credentialsNonExpired") Boolean credentialsNonExpired);

}
