package edu.estu.estufastingrestapi.core.service.concretes;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.domain.entity.concretes.Language;
import edu.estu.estufastingrestapi.core.repository.abstracts.LanguageRepository;
import edu.estu.estufastingrestapi.core.service.abstracts.LanguageService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.BaseReadableServiceImpl;
import edu.estu.estufastingrestapi.core.service.helper.EntityServiceHelper;
import edu.estu.estufastingrestapi.core.service.model.abstraction.Model;
import edu.estu.estufastingrestapi.core.service.model.request.language.LanguageCreateRequestModel;
import edu.estu.estufastingrestapi.core.service.model.request.language.LanguageUpdateRequestModel;
import edu.estu.estufastingrestapi.core.service.model.response.language.LanguageResponse;
import edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct.MapStructMapper;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceDataResponse;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceResponse;
import edu.estu.estufastingrestapi.core.service.response.helper.ResponseHelper;
import edu.estu.estufastingrestapi.core.service.response.success.ServiceSuccessDataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class LanguageServiceImpl extends BaseReadableServiceImpl<Language, Integer> implements LanguageService {

    private final LanguageRepository languageRepository;
    private final MapStructMapper<LanguageCreateRequestModel, Language> createRequestMapper;
    private final MapStructMapper<LanguageUpdateRequestModel, Language> updateRequestMapper;
    private final MapStructMapper<Language, LanguageResponse> languageResponseMapper;

    @Override
    public <P> ServiceResponse getByAlpha2(String alpha2, Class<P> projection) {
        return new ServiceSuccessDataResponse<>(languageRepository.findFirstByAlpha2(alpha2, projection).orElseThrow(EntityNotFoundException::new), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public ServiceDataResponse<Model> create(LanguageCreateRequestModel model) {
        Language saved = EntityServiceHelper.saveAndRefresh(languageRepository, createRequestMapper.map(model));
        return new ServiceSuccessDataResponse<>(languageResponseMapper.map(saved), MsgCode.COMMON_SUCCESS_SAVED);
    }

    @Override
    public ServiceResponse updateChanges(LanguageUpdateRequestModel model) {
        return new ServiceSuccessDataResponse<>(languageResponseMapper.map(updateRequestMapper.mapInto(model, repository.getReferenceById(model.getId()))), MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ServiceResponse updateName(Integer id, String name) {
        return ResponseHelper.getResponseBySuccess(languageRepository.updateName(id, name), MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ServiceResponse updateLocalName(Integer id, String localName) {
        return ResponseHelper.getResponseBySuccess(languageRepository.updateLocalName(id, localName), MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ServiceResponse updateAlpha2(Integer id, String alpha2) {
        return ResponseHelper.getResponseBySuccess(languageRepository.updateAlpha2(id, alpha2), MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ServiceResponse updateAlpha3T(Integer id, String alpha3T) {
        return ResponseHelper.getResponseBySuccess(languageRepository.updateAlpha3T(id, alpha3T), MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ServiceResponse updateUnlisted(Integer id, Boolean unlisted) {
        return ResponseHelper.getResponseBySuccess(languageRepository.updateUnlisted(id, unlisted), MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ServiceResponse updateSupported(Integer id, Boolean unlisted) {
        return ResponseHelper.getResponseBySuccess(languageRepository.updateSupported(id, unlisted), MsgCode.COMMON_SUCCESS_UPDATED);
    }

}
