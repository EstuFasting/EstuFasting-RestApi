package edu.estu.estufastingrestapi.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import edu.estu.estufastingrestapi.core.model.constants.Validation;
import edu.estu.estufastingrestapi.core.model.entities.abstracts.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tb_customer_type", uniqueConstraints = @UniqueConstraint(columnNames = "uq_name", name = "uk_customer_type_name"))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CustomerType extends BaseEntity<Integer> {

    @Id
    @Column(name = "id_customer_type", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "uq_name", nullable = false, length = Validation.CustomerType.CUSTOMER_TYPE_NAME)
    private String name;

    @Column(name = "tx_description", nullable = false, length = Validation.CustomerType.CUSTOMER_TYPE_DESC)
    private String description;

}
