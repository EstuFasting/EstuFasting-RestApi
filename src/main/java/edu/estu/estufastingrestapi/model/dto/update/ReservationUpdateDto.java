package edu.estu.estufastingrestapi.model.dto.update;

import edu.estu.estufastingrestapi.model.entities.Customer;
import edu.estu.estufastingrestapi.model.entities.Service;

import java.util.UUID;

public class ReservationUpdateDto {

    private UUID id;

    private Service service;

    private Customer customer;

}
