package edu.estu.estufastingrestapi.entities.concretes;

import edu.estu.estufastingrestapi.core.domain.constants.FK;
import edu.estu.estufastingrestapi.core.domain.constants.UK;
import edu.estu.estufastingrestapi.core.domain.entity.abstracts.BaseEntity;
import edu.estu.estufastingrestapi.entities.listeners.CateringListener;
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
@Table(name = "tb_reservation", uniqueConstraints = @UniqueConstraint(name = UK.RESERVATION_CUSTOMER_CATERING, columnNames = {"rf_customer", "rf_catering"}))
@EntityListeners(CateringListener.class)
public class Reservation extends BaseEntity<UUID> {

    @Id
    @Column(name = "id_catering", nullable = false)
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rf_customer", nullable = false, foreignKey = @ForeignKey(name = FK.RESERVATION_CUSTOMER))
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rf_catering", nullable = false, foreignKey = @ForeignKey(name = FK.RESERVATION_CATERING))
    private Catering catering;

    @Column(name = "is_paid", nullable = false)
    private Boolean paid;

}
