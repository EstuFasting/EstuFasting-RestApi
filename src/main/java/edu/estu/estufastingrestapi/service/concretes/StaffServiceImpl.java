package edu.estu.estufastingrestapi.service.concretes;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.domain.response.abstraction.ApiResponse;
import edu.estu.estufastingrestapi.core.domain.response.success.ApiSuccessDataResponse;
import edu.estu.estufastingrestapi.core.service.helper.EntityServiceHelper;
import edu.estu.estufastingrestapi.core.service.model.request.pagerequest.PageRequestModel;
import edu.estu.estufastingrestapi.core.service.objectmapping.manual.concretes.PageRequestMapper;
import edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct.MapStructMapper;
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
    public <P> ApiResponse getOneByIdentifier(String username, Class<P> projection) {
        return new ApiSuccessDataResponse<>(staffRepository.findFullyJoinedByUsername(username, projection).orElseThrow(EntityNotFoundException::new), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public <P> ApiResponse getList(PageRequestModel pageRequestModel, Class<P> projection) {
        return new ApiSuccessDataResponse<>(staffRepository.findAllBy(pageRequestMapper.map(pageRequestModel), projection), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public <P> ApiResponse getOneFullyJoinedByUsername(String username, Class<P> projection) {
        return new ApiSuccessDataResponse<>(staffRepository.findFullyJoinedByUsername(username, projection).orElseThrow(EntityNotFoundException::new), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public ApiResponse create(StaffCreateRequestModel model) {
        Staff saved = EntityServiceHelper.saveAndRefresh(staffRepository, createRequestMapper.map(model));
        return new ApiSuccessDataResponse<>(staffResponseMapper.map(saved), MsgCode.COMMON_SUCCESS_SAVED);
    }

}
