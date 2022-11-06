package edu.estu.estufastingrestapi.core.service.concretes;

import edu.estu.estufastingrestapi.core.model.dto.language.LanguageCreateDto;
import edu.estu.estufastingrestapi.core.model.dto.language.LanguageUpdateDto;
import edu.estu.estufastingrestapi.core.model.entities.concretes.Language;
import edu.estu.estufastingrestapi.core.service.abstracts.LanguageService;
import edu.estu.estufastingrestapi.core.service.abstracts.infrastructure.BaseEntityServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class LanguageServiceImpl extends BaseEntityServiceImpl<Language, Integer, LanguageCreateDto, LanguageUpdateDto> implements LanguageService {
}
