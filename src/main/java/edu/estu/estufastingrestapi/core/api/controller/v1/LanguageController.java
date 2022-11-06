package edu.estu.estufastingrestapi.core.api.controller.v1;

import edu.estu.estufastingrestapi.core.model.constants.Origin;
import edu.estu.estufastingrestapi.core.model.dto.language.LanguageGetDto;
import edu.estu.estufastingrestapi.core.model.dto.pagerequest.PageRequestDto;
import edu.estu.estufastingrestapi.core.model.response.abstracts.ApiResponse;
import edu.estu.estufastingrestapi.core.model.response.helper.ResponseBuilder;
import edu.estu.estufastingrestapi.core.service.abstracts.LanguageService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor

@CrossOrigin(origins = Origin.LOCALHOST_3000)
@RestController
@RequestMapping("/api/v1/language")
@Api(tags = "Language")
public class LanguageController {

    private final LanguageService languageService;

    @GetMapping("/get")
    public ResponseEntity<ApiResponse> get(@ModelAttribute PageRequestDto pageRequestDto) {
        return ResponseBuilder
                .status(HttpStatus.OK)
                .body(languageService.get(pageRequestDto, LanguageGetDto.class));
    }

    @GetMapping("/get/deleted")
    public ResponseEntity<ApiResponse> getDeletedByTrue(@ModelAttribute PageRequestDto pageRequestDto) {
        return ResponseBuilder
                .status(HttpStatus.OK)
                .body(languageService.getByDeletedTrue(pageRequestDto, LanguageGetDto.class));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ApiResponse> delete(@RequestParam Integer id) {
        return ResponseBuilder
                .status(HttpStatus.OK)
                .body(languageService.delete(id));
    }

}
