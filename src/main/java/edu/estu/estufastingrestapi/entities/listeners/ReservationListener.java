package edu.estu.estufastingrestapi.entities.listeners;

import edu.estu.estufastingrestapi.entities.concretes.Reservation;

import javax.persistence.PrePersist;
import java.time.LocalDate;

public class ReservationListener {

    @PrePersist
    public void prePersist(Reservation target) {
        target.setPaid(false);
    }

}
