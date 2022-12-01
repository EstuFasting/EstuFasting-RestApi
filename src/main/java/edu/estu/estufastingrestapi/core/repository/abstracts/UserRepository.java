package edu.estu.estufastingrestapi.core.repository.abstracts;

import edu.estu.estufastingrestapi.core.domain.entity.concretes.User;
import edu.estu.estufastingrestapi.core.service.model.response.user.UserAuthProjection;
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
                select s from User s
                left join fetch s.language l
                left join fetch s.roles r
                left join fetch r.privileges p
                where s.username = :username
            """)
    Optional<UserAuthProjection> findByUsernameForLogin(@Param("username") String username);

    @Query(value = """
                select s from User s
                left join fetch s.roles r
                left join fetch r.privileges p
                where s.username = :username
            """)
    <P> Optional<P> findUserAuthoritiesByUsername(String username, Class<P> projection);

    @Query(value = """
                select s.password from User s
                where s.username = :username
            """)
    String findPasswordByUsername(@Param("username") String username);

    @Query(value = """
                select s.id from User s
                where s.username = :username
            """)
    UUID findIdByUsername(@Param("username") String username);

    @Query(value = """
                select s from User s
                left join fetch s.language l
                left join fetch s.roles r
                left join fetch r.privileges p
                where s.username = :username
            """)
    <P> Optional<P> findFullyJoinedByUsername(@Param("username") String username, Class<P> projection);

    <P> Optional<P> findFirstByUsername(String username, Class<P> projection);

    <P> Optional<P> findFirstByPhoneNumber(String phoneNumber, Class<P> projection);

    @Modifying
    @Query("update User u set u.username = :newUsername where u.username = :username")
    int updateUserName(@Param("username") String username, @Param("newUsername") String newUsername);

    @Modifying
    @Query("update User u set u.phoneNumber = :phoneNumber where u.username = :username")
    int updatePhoneNumber(@Param("username") String username, @Param("phoneNumber") String phoneNumber);

    @Modifying
    @Query("update User u set u.language.id = :languageId where u.username = :username")
    int updateLanguage(@Param("username") String username, @Param("languageId") Integer languageId);

    @Modifying
    @Query("update User u set u.password = :password where u.username = :username")
    int updatePassword(@Param("username") String username, @Param("password") String password);

    @Modifying
    @Query("update User u set u.firstName = :firstName where u.username = :username")
    int updateFirstName(@Param("username") String username, @Param("firstName") String firstName);

    @Modifying
    @Query("update User u set u.lastName = :lastName where u.username = :username")
    int updateLastName(@Param("username") String username, @Param("lastName") String lastName);

    @Modifying
    @Query("update User u set u.birthDate = :birthDate where u.username = :username")
    int updateBirthDate(@Param("username") String username, @Param("birthDate") LocalDate birthDate);

    @Modifying
    @Query("update User u set u.enabled = :enabled where u.username = :username")
    int updateEnabled(@Param("username") String username, @Param("enabled") Boolean enabled);

    boolean deleteByUsername(String username);

}
