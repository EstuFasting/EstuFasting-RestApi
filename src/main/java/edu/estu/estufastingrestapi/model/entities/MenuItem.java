package edu.estu.estufastingrestapi.model.entities;

import edu.estu.estufastingrestapi.core.domain.constants.Validation;
import edu.estu.estufastingrestapi.core.domain.entity.abstracts.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tb_menu_item")
public class MenuItem extends BaseEntity<UUID> {

    @Id
    @Column(name = "id_menu", nullable = false)
    @GeneratedValue
    private UUID id;

    @Column(name = "uq_name", nullable = false, length = Validation.MenuItem.MENU_ITEM_NAME)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rf_menu", nullable = false, foreignKey = @ForeignKey(name = "fk_menu_item_menu"))
    private Menu menu;


}
