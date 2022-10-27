package edu.estu.estufastingrestapi.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import edu.estu.estufastingrestapi.core.model.constants.validation.SizeOf;
import edu.estu.estufastingrestapi.core.model.entities.abstracts.Readable;
import edu.estu.estufastingrestapi.core.model.entities.abstracts.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tb_menu_item")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MenuItem extends BaseEntity<UUID> implements Creatable, Readable, Updatable, Deletable {

    @Id
    @Column(name = "id_menu", nullable = false)
    @GeneratedValue
    private UUID id;

    @Column(name = "uq_name", nullable = false, length = SizeOf.Text.Max.MENU_ITEM_NAME)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rf_menu", nullable = false, foreignKey = @ForeignKey(name = "fk_menu_item_menu"))
    private Menu menu;


}