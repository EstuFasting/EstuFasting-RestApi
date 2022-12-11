package edu.estu.estufastingrestapi.entities.concretes;

import edu.estu.estufastingrestapi.core.domain.constants.UK;
import edu.estu.estufastingrestapi.core.domain.constants.Validation;
import edu.estu.estufastingrestapi.core.domain.entity.abstracts.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tb_menu_item", uniqueConstraints = @UniqueConstraint(columnNames = "uq_name", name = UK.MENU_ITEM_NAME))
public class MenuItem extends BaseEntity<UUID> {

    @Id
    @Column(name = "id_menu", nullable = false)
    @GeneratedValue
    private UUID id;

    @Column(name = "uq_name", nullable = false, length = Validation.MenuItem.MAX_LEN_NAME)
    private String name;

    @ColumnDefault("0")
    @Column(name = "qt_calories")
    private Integer calories;

}
