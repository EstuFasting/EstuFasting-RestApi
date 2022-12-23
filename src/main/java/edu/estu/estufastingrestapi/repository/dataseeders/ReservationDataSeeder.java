package edu.estu.estufastingrestapi.repository.dataseeders;

import edu.estu.estufastingrestapi.core.repository.dataseeders.abstracts.BaseDataSeeder;
import edu.estu.estufastingrestapi.entities.concretes.Catering;
import edu.estu.estufastingrestapi.entities.concretes.Customer;
import edu.estu.estufastingrestapi.entities.concretes.Reservation;
import edu.estu.estufastingrestapi.repository.abstracts.CateringRepository;
import edu.estu.estufastingrestapi.repository.abstracts.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

// will be removed on prod
@Component
@RequiredArgsConstructor
public class ReservationDataSeeder extends BaseDataSeeder<Reservation, UUID> {

    private final CustomerRepository customerRepository;
    private final CateringRepository cateringRepository;

    @Override
    public void setData() {
        Customer customer = customerRepository.findAll(Pageable.ofSize(1)).getContent().get(0);
        List<Catering> caterings = cateringRepository.findAll(Pageable.ofSize(20)).getContent();
        data.add(new Reservation(null, customer, caterings.get(0), true));
        data.add(new Reservation(null, customer, caterings.get(1), true));
        data.add(new Reservation(null, customer, caterings.get(2), true));
        data.add(new Reservation(null, customer, caterings.get(3), true));
        data.add(new Reservation(null, customer, caterings.get(4), true));
        data.add(new Reservation(null, customer, caterings.get(5), true));
        data.add(new Reservation(null, customer, caterings.get(6), true));
        data.add(new Reservation(null, customer, caterings.get(7), true));
        data.add(new Reservation(null, customer, caterings.get(8), true));
        data.add(new Reservation(null, customer, caterings.get(9), true));
    }

}
