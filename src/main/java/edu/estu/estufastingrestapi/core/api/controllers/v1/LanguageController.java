package edu.estu.estufastingrestapi.core.api.controllers.v1;

import edu.estu.estufastingrestapi.core.api.common.Origin;
import edu.estu.estufastingrestapi.core.api.common.ResponseBuilder;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.LogExecutionTime;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.Trimmed;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.Valid;
import edu.estu.estufastingrestapi.core.domain.constants.RoleConst;
import edu.estu.estufastingrestapi.core.service.abstracts.LanguageService;
import edu.estu.estufastingrestapi.core.service.model.request.language.LanguageCreateRequestModel;
import edu.estu.estufastingrestapi.core.service.model.request.pagerequest.PageRequestModel;
import edu.estu.estufastingrestapi.core.service.model.response.language.LanguageQuickProjection;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceResponse;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@LogExecutionTime
@Trimmed
@Validated

@CrossOrigin(origins = Origin.LOCALHOST_3000)
@RestController
@RequestMapping("/api/v1/language")
@Api(tags = "Language")
public class LanguageController {

    private final LanguageService languageService;

    @Secured(RoleConst.Name.USER)
    @GetMapping("/get/one/by_id")
    public ResponseEntity<ServiceResponse> getById(@RequestParam Integer id) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(languageService.getOneByIdentifier(id, LanguageQuickProjection.class));
    }

    @Secured(RoleConst.Name.USER)
    @GetMapping("/get/one/by_alpha_2")
    public ResponseEntity<ServiceResponse> getByAlpha2(@RequestParam String alpha2) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(languageService.getByAlpha2(alpha2, LanguageQuickProjection.class));
    }

    @Secured(RoleConst.Name.USER)
    @GetMapping("/get/list")
    public ResponseEntity<ServiceResponse> get(@ModelAttribute @Valid PageRequestModel pageRequestModel) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(languageService.getList(pageRequestModel, LanguageQuickProjection.class));
    }

    @Secured(RoleConst.Name.SUPER_ADMIN)
    @PostMapping("/create")
    public ResponseEntity<ServiceResponse> create(@RequestBody @Valid LanguageCreateRequestModel model) {
        return ResponseBuilder.status(HttpStatus.CREATED)
                .body(languageService.create(model));
    }

}
