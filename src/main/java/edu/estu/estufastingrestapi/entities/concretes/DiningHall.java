package edu.estu.estufastingrestapi.entities.concretes;

import edu.estu.estufastingrestapi.core.domain.constants.FK;
import edu.estu.estufastingrestapi.core.domain.constants.UK;
import edu.estu.estufastingrestapi.core.domain.constants.Validation;
import edu.estu.estufastingrestapi.core.domain.entity.abstracts.BaseEntity;
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
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tb_dining_hall",
        uniqueConstraints = @UniqueConstraint(columnNames = "uq_name", name = UK.DINING_HALL_NAME))
public class DiningHall extends BaseEntity<Integer> {

    @Id
    @Column(name = "id_dining_hall", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "uq_name", nullable = false, length = Validation.DiningHall.MAX_LEN_NAME)
    private String name;

    @Column(name = "tx_description", length = Validation.DiningHall.MAX_LEN_DESC)
    private String description;

    @Column(name = "tx_address", nullable = false, length = Validation.DiningHall.MAX_LEN_ADDRESS_LINE)
    private String address;

    @Column(name = "ft_latitude")
    private Double latitude;

    @Column(name = "ft_longitude")
    private Double longitude;

    @Column(name = "qt_capacity")
    private Integer capacity;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "tb_dining_hall_meal",
            joinColumns = @JoinColumn(name = "rf_dining_hall", nullable = false), foreignKey = @ForeignKey(name = FK.DINING_HALL_MEAL_DINING_HALL),
            inverseJoinColumns = @JoinColumn(name = "rf_meal", nullable = false), inverseForeignKey = @ForeignKey(name = FK.DINING_HALL_MEAL_MEAL),
            uniqueConstraints = @UniqueConstraint(name = UK.DINING_HALL_MEAL_DINING_HALL_MEAL, columnNames = {"rf_dining_hall", "rf_meal"})
    )
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Set<Meal> meals;

}
