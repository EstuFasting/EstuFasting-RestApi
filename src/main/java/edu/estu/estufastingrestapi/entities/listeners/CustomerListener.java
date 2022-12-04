package edu.estu.estufastingrestapi.entities.listeners;

import edu.estu.estufastingrestapi.core.domain.constants.RoleConst;
import edu.estu.estufastingrestapi.core.domain.entity.abstracts.Identifiable;
import edu.estu.estufastingrestapi.core.domain.entity.listeners.ListenerHelper;
import edu.estu.estufastingrestapi.entities.concretes.Catering;
import edu.estu.estufastingrestapi.entities.concretes.Customer;
import edu.estu.estufastingrestapi.entities.concretes.CustomerType;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;

public class CustomerListener {

    @PrePersist
    public void prePersist(Customer target) {
        target.setType(Identifiable.getInstance(CustomerType::new, 1));
        ListenerHelper.addToRoles(target, RoleConst.Name.CUSTOMER);
    }

    @PreRemove
    public void preRemove(Customer target) {
        for (Catering reservation : target.getReservations())
            target.getReservations().remove(reservation);
    }

}
