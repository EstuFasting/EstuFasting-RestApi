package edu.estu.estufastingrestapi.core.model.entities.concretes;

import edu.estu.estufastingrestapi.core.model.constants.Validation;
import edu.estu.estufastingrestapi.core.model.entities.abstracts.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "tb_user_password")
@SQLDelete(sql = "UPDATE tb_user_password SET is_deleted = '1' WHERE id_user_password=?")
public class Password extends BaseEntity<UUID> {

    @Id
    @GeneratedValue
    @Column(name = "id_user_password", nullable = false, updatable = false, length = Validation.Common.UUID)
    private UUID id;

    @Column(name = "tx_value", nullable = false, length = Validation.User.MAX_LEN_BCRYPT_PW)
    private String value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rf_user", nullable = false, foreignKey = @ForeignKey(name = "fk_user_password_user"))
    private User user;

}