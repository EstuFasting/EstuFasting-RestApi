package edu.estu.estufastingrestapi.core.domain.entity.concretes;

import edu.estu.estufastingrestapi.core.domain.constants.FK;
import edu.estu.estufastingrestapi.core.domain.constants.UK;
import edu.estu.estufastingrestapi.core.domain.constants.Validation;
import edu.estu.estufastingrestapi.core.domain.entity.abstracts.BaseEntity;
import edu.estu.estufastingrestapi.core.domain.entity.listeners.UserCreateListener;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(
        name = "tb_user",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "uq_username", name = UK.USER_USERNAME),
                @UniqueConstraint(columnNames = "uq_phone_number", name = UK.USER_PHONE_NUMBER)
        }
)
@EntityListeners(UserCreateListener.class)
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends BaseEntity<UUID> {

    @Id
    @GeneratedValue
    @Column(name = "id_user", updatable = false, nullable = false, length = Validation.Common.UUID)
    protected UUID id;

    @Column(name = "uq_username", nullable = false, length = Validation.User.MAX_LEN_EMAIL)
    protected String username;

    @Column(name = "uq_phone_number", length = Validation.User.MAX_LEN_PHONE_NUM)
    protected String phoneNumber;

    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rf_language", foreignKey = @ForeignKey(name = FK.USER_LANGUAGE))
    protected Language language;

    @Column(name = "tx_password", nullable = false, length = Validation.User.MAX_LEN_BCRYPT_PW)
    protected String password;

    @Column(name = "tx_first_name", nullable = false, length = Validation.User.MAX_LEN_FIRST_NAME)
    protected String firstName;

    @Column(name = "tx_last_name", nullable = false, length = Validation.User.MAX_LEN_LAST_NAME)
    protected String lastName;

    @Column(name = "dt_birth", nullable = false)
    protected LocalDate birthDate;

    @ColumnDefault("'1'")
    @Column(name = "is_enabled", insertable = false, nullable = false)
    protected Character enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "tb_user_role",
            joinColumns = @JoinColumn(name = "rf_user", nullable = false), foreignKey = @ForeignKey(name = FK.USER_ROLE_USER),
            inverseJoinColumns = @JoinColumn(name = "rf_role", nullable = false), inverseForeignKey = @ForeignKey(name = FK.USER_ROLE_ROLE),
            uniqueConstraints = @UniqueConstraint(name = UK.USER_ROLE_USER_ROLE, columnNames = {"rf_user", "rf_role"})
    )
    protected Set<Role> roles;

}

