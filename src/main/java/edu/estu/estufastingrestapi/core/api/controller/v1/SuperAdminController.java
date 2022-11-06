package edu.estu.estufastingrestapi.core.api.controller.v1;

import edu.estu.estufastingrestapi.core.model.constants.Origin;
import edu.estu.estufastingrestapi.core.model.dto.language.LanguageGetDto;
import edu.estu.estufastingrestapi.core.model.dto.pagerequest.PageRequestDto;
import edu.estu.estufastingrestapi.core.model.dto.superadmin.SuperAdminCreateDto;
import edu.estu.estufastingrestapi.core.model.dto.superadmin.SuperAdminUpdateDto;
import edu.estu.estufastingrestapi.core.model.response.abstracts.ApiResponse;
import edu.estu.estufastingrestapi.core.model.response.helper.ResponseBuilder;
import edu.estu.estufastingrestapi.core.service.abstracts.SuperAdminService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor

@CrossOrigin(origins = Origin.LOCALHOST_3000)
@RestController
@RequestMapping("/api/v1/super_admin")
@Api(tags = "Super Admin")
public class SuperAdminController {

    private final SuperAdminService superAdminService;

    @GetMapping("/get")
    public ResponseEntity<ApiResponse> get(@ModelAttribute PageRequestDto pageRequestDto) {
        return ResponseBuilder
                .status(HttpStatus.OK)
                .body(superAdminService.get(pageRequestDto, LanguageGetDto.class));
    }

    @GetMapping("/get/deleted")
    public ResponseEntity<ApiResponse> getDeletedByTrue(@ModelAttribute PageRequestDto pageRequestDto) {
        return ResponseBuilder
                .status(HttpStatus.OK)
                .body(superAdminService.getByDeletedTrue(pageRequestDto, LanguageGetDto.class));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ApiResponse> delete(@RequestParam UUID id) {
        return ResponseBuilder
                .status(HttpStatus.OK)
                .body(superAdminService.delete(id));
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> create(@RequestBody SuperAdminCreateDto dto) {
        return ResponseBuilder
                .status(HttpStatus.OK)
                .body(superAdminService.create(dto));
    }

    @PostMapping("/update")
    public ResponseEntity<ApiResponse> update(@RequestBody SuperAdminUpdateDto dto) {
        return ResponseBuilder
                .status(HttpStatus.OK)
                .body(superAdminService.update(dto));
    }
}
