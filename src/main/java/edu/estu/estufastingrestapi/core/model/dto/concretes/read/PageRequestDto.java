package edu.estu.estufastingrestapi.core.model.dto.concretes.read;

import edu.estu.estufastingrestapi.core.model.constants.validation.SizeOf;
import edu.estu.estufastingrestapi.core.model.dto.abstracts.Dto;
import edu.estu.estufastingrestapi.core.model.response.helper.Msg;
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
public class PageRequestDto implements Dto {

    @Min(value = SizeOf.Num.Min.PAGE_NUMBER, message = Msg.MIN)
    private Integer pageNo = 0;

    @Min(value = SizeOf.Num.Min.PAGE_SIZE, message = Msg.MIN)
    @Max(value = SizeOf.Num.Max.PAGE_SIZE, message = Msg.MAX)
    private Integer pageSize = 10;

    @Valid
    private SortDto sort;

}
