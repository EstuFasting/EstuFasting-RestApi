package edu.estu.estufastingrestapi.service.abstracts;

import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.CreatableService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.EntityService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.ReadableService;
import edu.estu.estufastingrestapi.core.service.model.request.pagerequest.PageRequestModel;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceResponse;
import edu.estu.estufastingrestapi.service.model.request.feedback.FeedbackCreateRequestModel;

import java.util.UUID;

public interface FeedbackService extends EntityService, CreatableService<FeedbackCreateRequestModel>, ReadableService<UUID> {

    <P> ServiceResponse getListByReviewed(Boolean reviewed, PageRequestModel pageRequestModel, Class<P> projection);

    <P> ServiceResponse getListByTopicContains(String containing, PageRequestModel pageRequestModel, Class<P> projection);

    <P> ServiceResponse getListByContentContains(String containing, PageRequestModel pageRequestModel, Class<P> projection);

    ServiceResponse updateReviewed(UUID id, Boolean reviewed);
}
