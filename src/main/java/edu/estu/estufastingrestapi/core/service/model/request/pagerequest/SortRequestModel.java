package edu.estu.estufastingrestapi.core.service.model.request.pagerequest;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.domain.constants.Validation;
import edu.estu.estufastingrestapi.core.service.model.request.abstraction.RequestModel;
import edu.estu.estufastingrestapi.core.service.validation.annotations.MaxCollectionSize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SortRequestModel implements RequestModel {

    @MaxCollectionSize(max = Validation.PageRequest.MAX_SIZE_ORDER_COUNT, message = MsgCode.VALIDATION_SORT_ORDERS_MAX_COLLECTION_SIZE)
    private List<@Valid OrderRequestModel> orders;

}
