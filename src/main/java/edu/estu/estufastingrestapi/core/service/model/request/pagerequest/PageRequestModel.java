package edu.estu.estufastingrestapi.core.service.model.request.pagerequest;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.domain.constants.Validation;
import edu.estu.estufastingrestapi.core.service.model.request.abstraction.RequestModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestModel implements RequestModel {

    @Min(value = Validation.PageRequest.MIN_VAL_PAGE_NUMBER, message = MsgCode.VALIDATION_PAGE_REQUEST_PAGE_NO_MIN)
    private Integer pageNo = 0;

    @Min(value = Validation.PageRequest.MIN_VAL_PAGE_SIZE, message = MsgCode.VALIDATION_PAGE_REQUEST_PAGE_SIZE_MIN)
    @Max(value = Validation.PageRequest.MAX_VAL_PAGE_SIZE, message = MsgCode.VALIDATION_PAGE_REQUEST_PAGE_SIZE_MAX)
    private Integer pageSize = 10;

    @Valid
    private SortRequestModel sort;

}
