package edu.estu.estufastingrestapi.service.concretes;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.service.helper.EntityServiceHelper;
import edu.estu.estufastingrestapi.core.service.model.abstraction.Model;
import edu.estu.estufastingrestapi.core.service.model.request.pagerequest.PageRequestModel;
import edu.estu.estufastingrestapi.core.service.objectmapping.manual.concretes.PageRequestMapper;
import edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct.MapStructMapper;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceDataResponse;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceResponse;
import edu.estu.estufastingrestapi.core.service.response.success.ServiceSuccessDataResponse;
import edu.estu.estufastingrestapi.entities.concretes.Staff;
import edu.estu.estufastingrestapi.repository.abstracts.StaffRepository;
import edu.estu.estufastingrestapi.service.abstracts.StaffService;
import edu.estu.estufastingrestapi.service.model.request.staff.StaffCreateRequestModel;
import edu.estu.estufastingrestapi.service.model.response.staff.StaffResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository;
    private final PageRequestMapper pageRequestMapper;
    private final MapStructMapper<StaffCreateRequestModel, Staff> createRequestMapper;
    private final MapStructMapper<Staff, StaffResponse> staffResponseMapper;

    @Override
    public ServiceResponse getCount() {
        return new ServiceSuccessDataResponse<>(staffRepository.count(), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public <P> ServiceDataResponse<P> getOneByIdentifier(String username, Class<P> projection) {
        return new ServiceSuccessDataResponse<>(staffRepository.findFullyJoinedByUsername(username, projection).orElseThrow(EntityNotFoundException::new), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public <P> ServiceResponse getList(PageRequestModel pageRequestModel, Class<P> projection) {
        return new ServiceSuccessDataResponse<>(staffRepository.findAllBy(pageRequestMapper.map(pageRequestModel), projection), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public <P> ServiceResponse getOneFullyJoinedByUsername(String username, Class<P> projection) {
        return new ServiceSuccessDataResponse<>(staffRepository.findFullyJoinedByUsername(username, projection).orElseThrow(EntityNotFoundException::new), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public ServiceDataResponse<Model> create(StaffCreateRequestModel model) {
        Staff saved = EntityServiceHelper.saveAndRefresh(staffRepository, createRequestMapper.map(model));
        return new ServiceSuccessDataResponse<>(staffResponseMapper.map(saved), MsgCode.COMMON_SUCCESS_SAVED);
    }

}
