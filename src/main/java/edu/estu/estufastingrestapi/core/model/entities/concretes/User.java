package edu.estu.estufastingrestapi.core.model.entities.concretes;

import edu.estu.estufastingrestapi.core.model.constants.Validation;
import edu.estu.estufastingrestapi.core.model.entities.abstracts.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(
        name = "tb_user",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "uq_username", name = "uk_user_username"),
                @UniqueConstraint(columnNames = "uq_email", name = "uk_user_email"),
                @UniqueConstraint(columnNames = "uq_phone_number", name = "uk_user_phone_number")
        }
)
@SQLDelete(sql = "UPDATE tb_user SET is_deleted = '1' WHERE id_user=?")
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends BaseEntity<UUID> {

    @Id
    @GeneratedValue
    @Column(name = "id_user", updatable = false, nullable = false, length = Validation.Common.UUID)
    protected UUID id;

    @Column(name = "uq_username", nullable = false, length = Validation.User.MAX_LEN_USERNAME)
    protected String username;

    @Column(name = "uq_email", nullable = false)
    protected String email;

    @Column(name = "uq_phone_number", length = Validation.User.MAX_LEN_PHONE_NUM)
    protected String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rf_language", foreignKey = @ForeignKey(name = "fk_user_language"))
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    protected Language language;

    @Column(name = "tx_password", nullable = false, length = Validation.User.MAX_LEN_BCRYPT_PW)
    protected String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    protected List<Password> passwords;

    @Column(name = "tx_first_name", nullable = false, length = Validation.User.MAX_LEN_FIRST_NAME)
    protected String firstName;

    @Column(name = "tx_last_name", nullable = false, length = Validation.User.MAX_LEN_LAST_NAME)
    protected String lastName;

    @Column(name = "dt_birth", nullable = false)
    protected LocalDate birthDate;

    @ColumnDefault("true")
    @Column(name = "is_enabled", insertable = false, nullable = false)
    protected boolean enabled;

    @ColumnDefault("true")
    @Column(name = "is_account_non_locked", insertable = false, nullable = false)
    protected boolean accountNonLocked;

    @ColumnDefault("true")
    @Column(name = "is_account_non_expired", insertable = false, nullable = false)
    protected boolean accountNonExpired;

    @ColumnDefault("true")
    @Column(name = "is_credentials_non_expired", insertable = false, nullable = false)
    protected boolean credentialsNonExpired;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tb_user_role",
            joinColumns = @JoinColumn(name = "rf_user", nullable = false), foreignKey = @ForeignKey(name = "fk_user_role_user"),
            inverseJoinColumns = @JoinColumn(name = "rf_role", nullable = false), inverseForeignKey = @ForeignKey(name = "fk_user_role_role"),
            uniqueConstraints = @UniqueConstraint(name = "uk_user_role_user_role", columnNames = {"rf_user", "rf_role"})
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    protected Collection<Role> roles;

}

