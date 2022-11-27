package edu.estu.estufastingrestapi.core.service.concretes;

import edu.estu.estufastingrestapi.core.domain.constants.MsgCode;
import edu.estu.estufastingrestapi.core.domain.entity.concretes.Language;
import edu.estu.estufastingrestapi.core.domain.response.ResponseHelper;
import edu.estu.estufastingrestapi.core.domain.response.abstraction.ApiResponse;
import edu.estu.estufastingrestapi.core.domain.response.success.ApiSuccessDataResponse;
import edu.estu.estufastingrestapi.core.repository.abstracts.LanguageRepository;
import edu.estu.estufastingrestapi.core.service.abstracts.LanguageService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.BaseReadableServiceImpl;
import edu.estu.estufastingrestapi.core.service.helper.EntityServiceHelper;
import edu.estu.estufastingrestapi.core.service.model.request.language.LanguageCreateRequestModel;
import edu.estu.estufastingrestapi.core.service.model.request.language.LanguageUpdateRequestModel;
import edu.estu.estufastingrestapi.core.service.model.response.language.LanguageResponse;
import edu.estu.estufastingrestapi.core.service.objectmapping.mapstruct.MapStructMapper;
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
    private final MapStructMapper<LanguageResponse, Language> languageResponseMapper;

    @Override
    public <P> ApiResponse getByAlpha2(String alpha2, Class<P> projection) {
        return new ApiSuccessDataResponse<>(languageRepository.findFirstByAlpha2(alpha2, projection).orElseThrow(EntityNotFoundException::new), MsgCode.COMMON_SUCCESS_FETCHED);
    }

    @Override
    public ApiResponse create(LanguageCreateRequestModel model) {
        Language saved = EntityServiceHelper.saveAndRefresh(languageRepository, createRequestMapper.map(model));
        return new ApiSuccessDataResponse<>(languageResponseMapper.mapReverse(saved), MsgCode.COMMON_SUCCESS_SAVED);
    }

    @Override
    public ApiResponse update(LanguageUpdateRequestModel model) {
        return new ApiSuccessDataResponse<>(languageResponseMapper.mapReverse(updateRequestMapper.mapInto(model, repository.getReferenceById(model.getId()))), MsgCode.COMMON_SUCCESS_UPDATED);
    }

    @Override
    public ApiResponse updateName(Integer id, String name) {
        return ResponseHelper.getResponseBySuccess(languageRepository.updateName(id, name) > 0);
    }

    @Override
    public ApiResponse updateLocalName(Integer id, String localName) {
        return ResponseHelper.getResponseBySuccess(languageRepository.updateLocalName(id, localName) > 0);
    }

    @Override
    public ApiResponse updateAlpha2(Integer id, String alpha2) {
        return ResponseHelper.getResponseBySuccess(languageRepository.updateAlpha2(id, alpha2) > 0);
    }

    @Override
    public ApiResponse updateAlpha3T(Integer id, String alpha3T) {
        return ResponseHelper.getResponseBySuccess(languageRepository.updateAlpha3T(id, alpha3T) > 0);
    }

    @Override
    public ApiResponse updateUnlisted(Integer id, Boolean unlisted) {
        return ResponseHelper.getResponseBySuccess(languageRepository.updateUnlisted(id, unlisted) > 0);
    }

    @Override
    public ApiResponse updateSupported(Integer id, Boolean unlisted) {
        return ResponseHelper.getResponseBySuccess(languageRepository.updateSupported(id, unlisted) > 0);
    }

}
