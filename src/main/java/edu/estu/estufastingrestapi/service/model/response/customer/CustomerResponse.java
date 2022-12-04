package edu.estu.estufastingrestapi.service.model.response.customer;

import edu.estu.estufastingrestapi.core.service.model.response.user.UserResponse;
import edu.estu.estufastingrestapi.service.model.response.catering.CateringResponse;
import edu.estu.estufastingrestapi.service.model.response.customertype.CustomerTypeResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse extends UserResponse {

    private String tckn;

    private String cardNo;

    private CustomerTypeResponse type;

    private List<CateringResponse> reservations;

}
