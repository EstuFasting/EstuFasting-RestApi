package edu.estu.estufastingrestapi.entities.concretes;

import edu.estu.estufastingrestapi.core.domain.constants.FK;
import edu.estu.estufastingrestapi.core.domain.constants.UK;
import edu.estu.estufastingrestapi.core.domain.constants.Validation;
import edu.estu.estufastingrestapi.core.domain.entity.concretes.User;
import edu.estu.estufastingrestapi.entities.listeners.CustomerListener;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(
        name = "tb_customer",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "uq_card_no", name = UK.CUSTOMER_CARD_NO),
                @UniqueConstraint(columnNames = "uq_tckn", name = UK.CUSTOMER_TCKN),
        }
)
@EntityListeners(CustomerListener.class)
@PrimaryKeyJoinColumn(name = "id_user", referencedColumnName = "id_user", foreignKey = @ForeignKey(name = FK.CUSTOMER_USER))
@OnDelete(action = OnDeleteAction.CASCADE)
public class Customer extends User {

    @Column(name = "uq_tckn", nullable = true, length = Validation.Customer.LEN_CUSTOMER_TCKN)
    private String tckn;

    @Column(name = "uq_card_no", nullable = true, length = Validation.Customer.MAX_CUSTOMER_CARD_NO)
    private String cardNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rf_customer_type", nullable = false, foreignKey = @ForeignKey(name = FK.CUSTOMER_CUSTOMER_TYPE))
    private CustomerType type;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tb_reservation",
            joinColumns = @JoinColumn(name = "rf_customer", nullable = false), foreignKey = @ForeignKey(name = FK.RESERVATION_CUSTOMER),
            inverseJoinColumns = @JoinColumn(name = "rf_catering", nullable = false), inverseForeignKey = @ForeignKey(name = FK.RESERVATION_SERVICE),
            uniqueConstraints = @UniqueConstraint(name = UK.RESERVATION_CUSTOMER_CATERING, columnNames = {"rf_customer", "rf_catering"})
    )
    private Set<Catering> reservations;

}
