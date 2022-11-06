package edu.estu.estufastingrestapi.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import edu.estu.estufastingrestapi.core.model.entities.abstracts.BaseEntity;
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
@Table(name = "tb_service")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Service extends BaseEntity<UUID> {

    @Id
    @Column(name = "id_service", nullable = false)
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rf_meal", nullable = false, foreignKey = @ForeignKey(name = "fk_service_meal"))
    private Meal meal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rf_menu", nullable = false, foreignKey = @ForeignKey(name = "fk_service_menu"))
    private Menu menu;

}
