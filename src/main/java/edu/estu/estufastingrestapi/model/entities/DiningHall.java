package edu.estu.estufastingrestapi.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import edu.estu.estufastingrestapi.core.model.constants.validation.SizeOf;
import edu.estu.estufastingrestapi.core.model.entities.abstracts.*;
import edu.estu.estufastingrestapi.core.model.entities.abstracts.Readable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tb_dining_hall",
        uniqueConstraints = @UniqueConstraint(columnNames = "uq_name", name = "uk_dining_hall_name"))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DiningHall extends BaseEntity<Integer> implements Creatable, Readable, Updatable, Deletable {

    @Id
    @Column(name = "id_dining_hall", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "uq_name", length = SizeOf.Text.Max.DINING_HALL_NAME)
    private String name;

    @Column(name = "tx_address_line_1", length = SizeOf.Text.Max.DINING_HALL_ADDRESS_LINE)
    private String addressLine1;

    @Column(name = "tx_address_line_2", length = SizeOf.Text.Max.DINING_HALL_ADDRESS_LINE)
    private String addressLine2;

    // temp
    @Column(name = "qt_capacity")
    private Integer capacity;
}
