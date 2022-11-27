package edu.estu.estufastingrestapi.core.service.objectmapping.manual.concretes;

import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.ReturnIfNull;
import edu.estu.estufastingrestapi.core.service.model.request.pagerequest.OrderRequestModel;
import edu.estu.estufastingrestapi.core.service.objectmapping.manual.abstracts.ManualMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper implements ManualMapper<OrderRequestModel, Sort.Order> {

    @Override
    public Sort.Order map(@ReturnIfNull OrderRequestModel orderModel) {
        return orderModel.isIgnoreCase() ?
                new Sort.Order(orderModel.getDirection(), orderModel.getProperty(), orderModel.getNullHandling()).ignoreCase() :
                new Sort.Order(orderModel.getDirection(), orderModel.getProperty(), orderModel.getNullHandling());
    }

}
