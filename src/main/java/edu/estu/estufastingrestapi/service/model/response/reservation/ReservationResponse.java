package edu.estu.estufastingrestapi.service.model.response.reservation;

import edu.estu.estufastingrestapi.core.service.model.response.abstraction.AuditedResponse;
import edu.estu.estufastingrestapi.service.model.response.catering.CateringResponse;
import edu.estu.estufastingrestapi.service.model.response.customer.CustomerResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationResponse extends AuditedResponse {

    private UUID id;

    private CustomerResponse customer;

    private CateringResponse catering;

    private Boolean paid;

}
