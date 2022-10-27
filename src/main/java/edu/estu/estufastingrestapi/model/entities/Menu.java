package edu.estu.estufastingrestapi.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import edu.estu.estufastingrestapi.core.model.entities.abstracts.*;
import edu.estu.estufastingrestapi.core.model.entities.abstracts.Readable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Collection;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tb_menu")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Menu extends BaseEntity<UUID> implements Creatable, Readable, Updatable, Deletable {

    @Id
    @Column(name = "id_menu", nullable = false)
    @GeneratedValue
    private UUID id;

    @OneToMany(mappedBy = "menu", fetch = FetchType.EAGER)
    private Collection<MenuItem> menuItems;
}
