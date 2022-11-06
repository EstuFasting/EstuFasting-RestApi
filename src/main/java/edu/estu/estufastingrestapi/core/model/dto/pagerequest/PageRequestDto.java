package edu.estu.estufastingrestapi.core.model.dto.pagerequest;

import edu.estu.estufastingrestapi.core.model.constants.Validation;
import edu.estu.estufastingrestapi.core.model.dto.abstraction.Dto;
import edu.estu.estufastingrestapi.core.model.response.helper.Msg;
import io.swagger.annotations.ApiModel;
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
@ApiModel(description = "Super type of user's authentication dto. Not used directly.")
public class PageRequestDto implements Dto {

    @Min(value = Validation.PageRequest.MIN_VAL_PAGE_NUMBER, message = Msg.MIN)
    private Integer pageNo = 0;

    @Min(value = Validation.PageRequest.MIN_VAL_PAGE_SIZE, message = Msg.MIN)
    @Max(value = Validation.PageRequest.MAX_VAL_PAGE_SIZE, message = Msg.MAX)
    private Integer pageSize = 10;

    @Valid
    private SortDto sort;

}
