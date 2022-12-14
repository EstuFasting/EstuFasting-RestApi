package edu.estu.estufastingrestapi.core.service.concretes;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.domain.entity.concretes.SuperAdmin;
import edu.estu.estufastingrestapi.core.repository.abstracts.SuperAdminRepository;
import edu.estu.estufastingrestapi.core.repository.abstracts.UserRepository;
import edu.estu.estufastingrestapi.core.service.abstracts.SuperAdminService;
import edu.estu.estufastingrestapi.core.service.helper.EntityServiceHelper;
import edu.estu.estufastingrestapi.core.service.model.abstraction.Model;
import edu.estu.estufastingrestapi.core.service.model.request.pagerequest.PageRequestModel;
import edu.estu.estufastingrestapi.core.service.model.request.superadmin.SuperAdminCreateRequestModel;
import edu.estu.estufastingrestapi.core.service.model.request.superadmin.SuperAdminUpdateRequestModel;
import edu.estu.estufastingrestapi.core.service.model.response.superadmin.SuperAdminResponse;
import edu.estu.estufastingrestapi.core.service.objectmapping.manual.concretes.PageRequestMapper;
import edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct.MapStructMapper;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceDataResponse;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceResponse;
import edu.estu.estufastingrestapi.core.service.response.success.ServiceSuccessDataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SuperAdminServiceImpl implements SuperAdminService {

    private final SuperAdminRepository superAdminRepository;
    private final UserRepository userRepository;
    private final MapStructMapper<SuperAdminCreateRequestModel, SuperAdmin> createRequestMapper;
    private final MapStructMapper<SuperAdminUpdateRequestModel, SuperAdmin> updateRequestMapper;
    private final MapStructMapper<SuperAdmin, SuperAdminResponse> superAdminResponseMapper;
    private final PageRequestMapper pageRequestMapper;

    @Override
    public <P> ServiceDataResponse<P> getOneByIdentifier(String username, Class<P> projection) {
        return new ServiceSuccessDataResponse<>(superAdminRepository.findFullyJoinedByUsername(username, projection).orElseThrow(EntityNotFoundException::new), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public <P> ServiceResponse getList(PageRequestModel pageRequestModel, Class<P> projection) {
        return new ServiceSuccessDataResponse<>(superAdminRepository.findAllBy(pageRequestMapper.map(pageRequestModel), projection), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public <P> ServiceResponse getOneFullyJoinedByUsername(String username, Class<P> projection) {
        return new ServiceSuccessDataResponse<>(superAdminRepository.findFullyJoinedByUsername(username, projection).orElseThrow(EntityNotFoundException::new), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public ServiceDataResponse<Model> create(SuperAdminCreateRequestModel model) {
        SuperAdmin saved = EntityServiceHelper.saveAndRefresh(superAdminRepository, createRequestMapper.map(model));
        return new ServiceSuccessDataResponse<>(superAdminResponseMapper.map(saved), MsgCode.COMMON_SUCCESS_SAVED);
    }

    @Override
    public ServiceResponse updateChanges(SuperAdminUpdateRequestModel model) {
        SuperAdmin updated = updateRequestMapper.mapInto(model, superAdminRepository.getReferenceById(userRepository.findIdByUsername(model.getUsername())));
        return new ServiceSuccessDataResponse<>(superAdminResponseMapper.map(updated), MsgCode.COMMON_SUCCESS_UPDATED);
    }

}
