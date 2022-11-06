package edu.estu.estufastingrestapi.core.service.objectmapping.manual.concretes;

import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.ReturnIfNull;
import edu.estu.estufastingrestapi.core.model.dto.pagerequest.OrderDto;
import edu.estu.estufastingrestapi.core.service.objectmapping.manual.abstracts.ManualMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper implements ManualMapper<OrderDto, Sort.Order> {

    @Override
    public Sort.Order map(@ReturnIfNull OrderDto orderDto) {
        return orderDto.isIgnoreCase() ?
                new Sort.Order(orderDto.getDirection(), orderDto.getProperty(), orderDto.getNullHandling()).ignoreCase() :
                new Sort.Order(orderDto.getDirection(), orderDto.getProperty(), orderDto.getNullHandling());
    }

}
