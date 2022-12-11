package edu.estu.estufastingrestapi.service.concretes;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.BaseReadableServiceImpl;
import edu.estu.estufastingrestapi.core.service.helper.EntityServiceHelper;
import edu.estu.estufastingrestapi.core.service.model.abstraction.Model;
import edu.estu.estufastingrestapi.core.service.model.request.pagerequest.PageRequestModel;
import edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct.MapStructMapper;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceDataResponse;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceResponse;
import edu.estu.estufastingrestapi.core.service.response.helper.ResponseHelper;
import edu.estu.estufastingrestapi.core.service.response.success.ServiceSuccessDataResponse;
import edu.estu.estufastingrestapi.entities.concretes.Feedback;
import edu.estu.estufastingrestapi.repository.abstracts.FeedbackRepository;
import edu.estu.estufastingrestapi.service.abstracts.FeedbackService;
import edu.estu.estufastingrestapi.service.model.request.feedback.FeedbackCreateRequestModel;
import edu.estu.estufastingrestapi.service.model.response.feedback.FeedbackResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class FeedbackServiceImpl extends BaseReadableServiceImpl<Feedback, UUID> implements FeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final MapStructMapper<FeedbackCreateRequestModel, Feedback> createRequestMapper;
    private final MapStructMapper<Feedback, FeedbackResponse> responseMapper;

    @Override
    public <P> ServiceResponse getListByReviewed(Boolean reviewed, PageRequestModel pageRequestModel, Class<P> projection) {
        return new ServiceSuccessDataResponse<>(feedbackRepository.findByReviewed(reviewed, pageRequestMapper.map(pageRequestModel), projection), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public <P> ServiceResponse getListByTopicContains(String containing, PageRequestModel pageRequestModel, Class<P> projection) {
        return new ServiceSuccessDataResponse<>(feedbackRepository.findByTopicContainingIgnoreCase(containing, pageRequestMapper.map(pageRequestModel), projection), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public <P> ServiceResponse getListByContentContains(String containing, PageRequestModel pageRequestModel, Class<P> projection) {
        return new ServiceSuccessDataResponse<>(feedbackRepository.findByContentContainingIgnoreCase(containing, pageRequestMapper.map(pageRequestModel), projection), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public ServiceDataResponse<Model> create(FeedbackCreateRequestModel model) {
        Feedback saved = EntityServiceHelper.saveAndRefresh(feedbackRepository, createRequestMapper.map(model));
        return new ServiceSuccessDataResponse<>(responseMapper.map(saved), MsgCode.COMMON_SUCCESS_SAVED);
    }

    @Override
    public ServiceResponse updateReviewed(UUID id, Boolean reviewed) {
        return ResponseHelper.getResponseBySuccess(feedbackRepository.updateReviewed(id, reviewed), MsgCode.COMMON_SUCCESS_UPDATED);
    }

}
