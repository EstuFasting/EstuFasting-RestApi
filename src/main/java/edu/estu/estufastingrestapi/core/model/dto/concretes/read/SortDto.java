package sk6.my.templateproject.core.model.dto.concretes.read;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk6.my.templateproject.core.service.validation.annotations.MaxCollectionSize;

import javax.validation.Valid;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SortDto {

    @MaxCollectionSize(3)
    private List<@Valid OrderDto> orders;

}
