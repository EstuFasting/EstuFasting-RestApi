package edu.estu.estufastingrestapi.core.domain.entity.concretes;

import edu.estu.estufastingrestapi.core.domain.constants.FK;
import edu.estu.estufastingrestapi.core.domain.constants.Validation;
import edu.estu.estufastingrestapi.core.domain.entity.abstracts.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "tb_user_password", indexes = @Index(columnList = "rf_user", name = "ix_country_user"))
public class Password extends BaseEntity<UUID> {

    @Id
    @GeneratedValue
    @Column(name = "id_user_password", nullable = false, updatable = false, length = Validation.Common.UUID)
    private UUID id;

    @Column(name = "tx_value", nullable = false, length = Validation.User.MAX_LEN_BCRYPT_PW)
    private String value;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rf_user", nullable = false, foreignKey = @ForeignKey(name = FK.USER_PASSWORD_USER))
    private User user;

}