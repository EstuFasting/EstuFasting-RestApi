package edu.estu.estufastingrestapi.model.entities;

import edu.estu.estufastingrestapi.core.domain.constants.Validation;
import edu.estu.estufastingrestapi.core.domain.entity.concretes.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(
        name = "tb_customer",
        uniqueConstraints = @UniqueConstraint(columnNames = "uq_card_no", name = "uk_customer_card_no")
)
@PrimaryKeyJoinColumn(name = "id_user", referencedColumnName = "id_user", foreignKey = @ForeignKey(name = "fk_customer_user"))
@OnDelete(action = OnDeleteAction.CASCADE)
public class Customer extends User {

    @Column(name = "uq_card_no", nullable = false, length = Validation.Customer.CUSTOMER_CARD_NO)
    private String cardNo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rf_customer_type", nullable = false, foreignKey = @ForeignKey(name = "fk_customer_customer_type"))
    private CustomerType type;

}
