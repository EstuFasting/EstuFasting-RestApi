package edu.estu.estufastingrestapi.entities.concretes;

import edu.estu.estufastingrestapi.core.domain.constants.FK;
import edu.estu.estufastingrestapi.core.domain.constants.UK;
import edu.estu.estufastingrestapi.core.domain.entity.abstracts.BaseEntity;
import edu.estu.estufastingrestapi.entities.listeners.CateringListener;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(
        name = "tb_catering",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"dt_date", " rf_meal"}, name = UK.CATERING_DATE_MEAL)
        }
)
@EntityListeners(CateringListener.class)
public class Catering extends BaseEntity<UUID> {

    @Id
    @Column(name = "id_catering", nullable = false)
    @GeneratedValue
    private UUID id;

    @Column(name = "dt_date")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rf_meal", nullable = false, foreignKey = @ForeignKey(name = FK.CATERING_MEAL))
    private Meal meal;

    @Column(name = "ft_price", nullable = false)
    private Double price;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tb_menu",
            joinColumns = @JoinColumn(name = "rf_catering", nullable = false), foreignKey = @ForeignKey(name = FK.MENU_CATERING),
            inverseJoinColumns = @JoinColumn(name = "rf_menu_item", nullable = false), inverseForeignKey = @ForeignKey(name = FK.MENU_MENU_ITEM),
            uniqueConstraints = @UniqueConstraint(name = UK.MENU_CATERING_MENU_ITEM, columnNames = {"rf_catering", "rf_menu_item"})
    )
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Set<MenuItem> menuItems;

    @ManyToMany(mappedBy = "reservations", fetch = FetchType.LAZY)
    private Set<Customer> customers;

}
