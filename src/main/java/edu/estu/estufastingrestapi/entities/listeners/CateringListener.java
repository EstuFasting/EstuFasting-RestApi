package edu.estu.estufastingrestapi.entities.listeners;

import edu.estu.estufastingrestapi.entities.concretes.Catering;

import javax.persistence.PrePersist;

public class CateringListener {

    @PrePersist
    public void prePersist(Catering target) {
        if (target.getPrice() == null) target.setPrice(5.0);
    }

}
