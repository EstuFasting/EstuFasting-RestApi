package edu.estu.estufastingrestapi.entities.concretes;

import edu.estu.estufastingrestapi.core.domain.constants.UK;
import edu.estu.estufastingrestapi.core.domain.constants.Validation;
import edu.estu.estufastingrestapi.core.domain.entity.abstracts.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tb_meal", uniqueConstraints = @UniqueConstraint(columnNames = "uq_name", name = UK.MEAL_NAME))
public class Meal extends BaseEntity<Integer> {

    @Id
    @Column(name = "id_meal", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "uq_name", nullable = false, length = Validation.Meal.MAX_LEN_NAME)
    private String name;

    @Column(name = "dt_start", nullable = false)
    private LocalTime start;

    @Column(name = "dt_end", nullable = false)
    private LocalTime end;

    @ManyToMany(mappedBy = "meals", fetch = FetchType.LAZY)
    private Set<DiningHall> diningHalls;

}
