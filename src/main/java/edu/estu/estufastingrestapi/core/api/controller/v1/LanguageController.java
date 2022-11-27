package edu.estu.estufastingrestapi.core.api.controller.v1;

import edu.estu.estufastingrestapi.core.api.common.Origin;
import edu.estu.estufastingrestapi.core.api.common.ResponseBuilder;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.LogExecutionTime;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.Trimmed;
import edu.estu.estufastingrestapi.core.domain.response.abstraction.ApiResponse;
import edu.estu.estufastingrestapi.core.service.abstracts.LanguageService;
import edu.estu.estufastingrestapi.core.service.model.request.pagerequest.PageRequestModel;
import edu.estu.estufastingrestapi.core.service.model.response.language.LanguageQuickProjection;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@LogExecutionTime
@Trimmed

@CrossOrigin(origins = Origin.LOCALHOST_3000)
@RestController
@RequestMapping("/api/v1/language")
@Api(tags = "Language")
public class LanguageController {

    private final LanguageService languageService;

    @GetMapping("/get/by_id")
    public ResponseEntity<ApiResponse> getById(@RequestParam Integer id) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(languageService.getById(id, LanguageQuickProjection.class));
    }

    @GetMapping("/get/by_alpha_2")
    public ResponseEntity<ApiResponse> getByAlpha2(@RequestParam String alpha2) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(languageService.getByAlpha2(alpha2, LanguageQuickProjection.class));
    }

    @GetMapping("/get")
    public ResponseEntity<ApiResponse> get(@ModelAttribute PageRequestModel pageRequestModel) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(languageService.get(pageRequestModel, LanguageQuickProjection.class));
    }

}
