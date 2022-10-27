package sk6.my.templateproject.core.model.dto.concretes.read;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk6.my.templateproject.core.model.constants.validation.SizeOf;
import sk6.my.templateproject.core.model.dto.abstracts.Dto;
import sk6.my.templateproject.core.model.response.helper.Msg;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Super type of user's create dto. Not used directly.")
public class PageRequestDto implements Dto {

    @Min(value = SizeOf.Num.Min.PAGE_NUMBER, message = Msg.MIN)
    private Integer pageNo = 0;

    @Min(value = SizeOf.Num.Min.PAGE_SIZE, message = Msg.MIN)
    @Max(value = SizeOf.Num.Max.PAGE_SIZE, message = Msg.MAX)
    private Integer pageSize = 10;

    @Valid
    private SortDto sort;

}
