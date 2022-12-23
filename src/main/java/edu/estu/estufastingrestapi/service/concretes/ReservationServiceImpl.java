package edu.estu.estufastingrestapi.service.concretes;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.BaseReadableServiceImpl;
import edu.estu.estufastingrestapi.core.service.helper.EntityServiceHelper;
import edu.estu.estufastingrestapi.core.service.model.abstraction.Model;
import edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct.MapStructMapper;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceDataResponse;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceResponse;
import edu.estu.estufastingrestapi.core.service.response.helper.ResponseHelper;
import edu.estu.estufastingrestapi.core.service.response.success.ServiceSuccessDataResponse;
import edu.estu.estufastingrestapi.core.service.response.success.ServiceSuccessResponse;
import edu.estu.estufastingrestapi.entities.concretes.Reservation;
import edu.estu.estufastingrestapi.repository.abstracts.CateringRepository;
import edu.estu.estufastingrestapi.repository.abstracts.ReservationRepository;
import edu.estu.estufastingrestapi.service.abstracts.ReservationService;
import edu.estu.estufastingrestapi.service.model.request.reservation.ReservationCreateRequestModel;
import edu.estu.estufastingrestapi.service.model.response.reservation.ReservationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ReservationServiceImpl extends BaseReadableServiceImpl<Reservation, UUID> implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final CateringRepository cateringRepository;
    private final MapStructMapper<ReservationCreateRequestModel, Reservation> createRequestMapper;
    private final MapStructMapper<Reservation, ReservationResponse> responseMapper;

    private Reservation createSimple(ReservationCreateRequestModel model) {
        if (cateringRepository.existsByIdAndDateBefore(model.getCateringId(), LocalDate.now()))
            throw new IllegalArgumentException(MsgCode.VALIDATION_RESERVATION_CATERING_DATE_FUTURE);
        return EntityServiceHelper.saveAndRefresh(repository, createRequestMapper.map(model));
    }

    @Override
    public ServiceDataResponse<Model> create(ReservationCreateRequestModel model) {
        return new ServiceSuccessDataResponse<>(responseMapper.map(createSimple(model)), MsgCode.CUSTOMER_RESERVATION_MAKE_SUCCESS);
    }

    @Override
    public ServiceDataResponse<List<?>> createMultiple(List<ReservationCreateRequestModel> models) {
        List<ReservationResponse> reservationResponseList = new LinkedList<>();
        for (ReservationCreateRequestModel model : models)
            reservationResponseList.add(responseMapper.map(createSimple(model)));
        return new ServiceSuccessDataResponse<>(reservationResponseList, MsgCode.CUSTOMER_RESERVATION_MAKE_SUCCESS);
    }

    @Override
    public ServiceResponse updatePaid(UUID id, Boolean paid) {
        return ResponseHelper.getResponseBySuccess(reservationRepository.updatePaid(id, paid), MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ServiceResponse completePaymentMultiple(List<UUID> ids) {
        boolean success = true;
        for (UUID id : ids)
            if (reservationRepository.updatePaid(id, true) == 0) success = false;
        return ResponseHelper.getResponseBySuccess(success, MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ServiceResponse delete(UUID id) {
        repository.deleteById(id);
        return new ServiceSuccessResponse(MsgCode.CUSTOMER_RESERVATION_CANCEL_SUCCESS);
    }

}
