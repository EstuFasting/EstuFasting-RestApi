package edu.estu.estufastingrestapi.core.model.entities.concretes;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import edu.estu.estufastingrestapi.core.model.constants.validation.SizeOf;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User extends BaseEntity<UUID> {

    @Id
    @GeneratedValue
    @Column(name = "id_user", updatable = false, nullable = false, length = SizeOf.Text.Max.UUID)
    protected UUID id;

    @Column(name = "uq_username", nullable = false, length = SizeOf.Text.Max.USERNAME)
    protected String username;

    @Column(name = "uq_email", nullable = false)
    protected String email;

    @Column(name = "uq_phone_number", nullable = false, length = SizeOf.Text.Max.PHONE_NUM)
    protected String phoneNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rf_language", nullable = false, foreignKey = @ForeignKey(name = "fk_user_language"))
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    protected Language language;

    @JsonIgnore
    @Column(name = "tx_password", nullable = false, length = SizeOf.Text.Max.BCRYPT_PW)
    protected String password;

    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    protected List<Password> passwords;

    @Column(name = "tx_first_name", nullable = false, length = SizeOf.Text.Max.FIRST_NAME)
    protected String firstName;

    @Column(name = "tx_last_name", nullable = false, length = SizeOf.Text.Max.LAST_NAME)
    protected String lastName;

    @JsonFormat(pattern = "yyyy-MM-dd")
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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "tb_user_role",
            joinColumns = @JoinColumn(name = "rf_user", nullable = false), foreignKey = @ForeignKey(name = "fk_user_role_user"),
            inverseJoinColumns = @JoinColumn(name = "rf_role", nullable = false), inverseForeignKey = @ForeignKey(name = "fk_user_role_role"),
            uniqueConstraints = @UniqueConstraint(name = "uk_user_role_user_role", columnNames = {"rf_user", "rf_role"})
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    protected Collection<Role> roles;

}

