package edu.estu.estufastingrestapi.core.model.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import edu.estu.estufastingrestapi.core.model.constants.validation.SizeOf;
import edu.estu.estufastingrestapi.core.model.entities.abstracts.Readable;
import edu.estu.estufastingrestapi.core.model.entities.abstracts.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "tb_user_password")
@SQLDelete(sql = "UPDATE tb_user_password SET is_deleted = '1' WHERE id_user_password=?")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Password extends BaseEntity<UUID> implements Creatable, Readable, Updatable, Deletable {

    @Id
    @GeneratedValue
    @Column(name = "id_user_password", nullable = false, updatable = false, length = SizeOf.Text.Max.UUID)
    private UUID id;

    @JsonIgnore
    @Column(name = "tx_value", nullable = false, length = SizeOf.Text.Max.BCRYPT_PW)
    private String value;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rf_user", nullable = false, foreignKey = @ForeignKey(name = "fk_user_password_user"))
    private User user;

}