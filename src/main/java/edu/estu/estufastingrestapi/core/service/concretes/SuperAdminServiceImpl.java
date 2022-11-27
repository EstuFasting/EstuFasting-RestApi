package edu.estu.estufastingrestapi.core.service.concretes;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.domain.entity.concretes.SuperAdmin;
import edu.estu.estufastingrestapi.core.domain.response.abstraction.ApiResponse;
import edu.estu.estufastingrestapi.core.domain.response.success.ApiSuccessDataResponse;
import edu.estu.estufastingrestapi.core.repository.abstracts.SuperAdminRepository;
import edu.estu.estufastingrestapi.core.service.abstracts.SuperAdminService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.BaseReadableServiceImpl;
import edu.estu.estufastingrestapi.core.service.helper.EntityServiceHelper;
import edu.estu.estufastingrestapi.core.service.model.request.superadmin.SuperAdminCreateRequestModel;
import edu.estu.estufastingrestapi.core.service.model.request.superadmin.SuperAdminUpdateRequestModel;
import edu.estu.estufastingrestapi.core.service.model.response.superadmin.SuperAdminResponse;
import edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct.MapStructMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class SuperAdminServiceImpl extends BaseReadableServiceImpl<SuperAdmin, UUID> implements SuperAdminService {

    private final SuperAdminRepository superAdminRepository;
    private final MapStructMapper<SuperAdminCreateRequestModel, SuperAdmin> createRequestMapper;
    private final MapStructMapper<SuperAdminUpdateRequestModel, SuperAdmin> updateRequestMapper;
    private final MapStructMapper<SuperAdminResponse, SuperAdmin> superAdminResponseMapper;

    @Override
    public <P> ApiResponse getFullyJoinedById(UUID id, Class<P> projection) {
        return new ApiSuccessDataResponse<>(superAdminRepository.findFullyJoinedById(id, projection).orElseThrow(EntityNotFoundException::new), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public <P> ApiResponse getFullyJoinedByUsername(String username, Class<P> projection) {
        return new ApiSuccessDataResponse<>(superAdminRepository.findFullyJoinedByUsername(username, projection).orElseThrow(EntityNotFoundException::new), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public ApiResponse create(SuperAdminCreateRequestModel model) {
        SuperAdmin saved = EntityServiceHelper.saveAndRefresh(superAdminRepository, createRequestMapper.map(model));
        return new ApiSuccessDataResponse<>(superAdminResponseMapper.mapReverse(saved), MsgCode.COMMON_SUCCESS_SAVED);
    }

    @Override
    public ApiResponse update(SuperAdminUpdateRequestModel model) {
        SuperAdmin updated = updateRequestMapper.mapInto(model, superAdminRepository.getReferenceById(model.getId()));
        return new ApiSuccessDataResponse<>(superAdminResponseMapper.mapReverse(updated), MsgCode.COMMON_SUCCESS_UPDATED);
    }

}
