package edu.estu.estufastingrestapi.api.controllers.v1;

import edu.estu.estufastingrestapi.core.api.common.Origin;
import edu.estu.estufastingrestapi.core.api.common.ResponseBuilder;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.LogExecutionTime;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.Trimmed;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.Valid;
import edu.estu.estufastingrestapi.core.domain.constants.RoleConst;
import edu.estu.estufastingrestapi.core.service.model.request.pagerequest.PageRequestModel;
import edu.estu.estufastingrestapi.core.service.response.abstraction.ServiceResponse;
import edu.estu.estufastingrestapi.service.abstracts.FeedbackService;
import edu.estu.estufastingrestapi.service.model.request.feedback.FeedbackCreateRequestModel;
import edu.estu.estufastingrestapi.service.model.response.feedback.FeedbackQuickProjection;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@LogExecutionTime
@Trimmed
@Validated

@CrossOrigin(origins = Origin.LOCALHOST_3000)
@RestController
@RequestMapping("/api/v1/feedback")
@Api(tags = "Feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;

    @Secured({RoleConst.Name.STAFF, RoleConst.Name.SUPER_ADMIN})
    @GetMapping("/get/list/quick")
    public ResponseEntity<ServiceResponse> getListQuick(
            @ModelAttribute @Valid PageRequestModel pageRequestModel) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(feedbackService.getList(pageRequestModel, FeedbackQuickProjection.class));
    }

    @Secured({RoleConst.Name.STAFF, RoleConst.Name.SUPER_ADMIN})
    @GetMapping("/get/list/quick/by_reviewed")
    public ResponseEntity<ServiceResponse> getListQuickByReviewed(
            @RequestParam Boolean reviewed, @ModelAttribute @Valid PageRequestModel pageRequestModel) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(feedbackService.getListByReviewed(reviewed, pageRequestModel, FeedbackQuickProjection.class));
    }

    @Secured({RoleConst.Name.STAFF, RoleConst.Name.SUPER_ADMIN})
    @GetMapping("/get/list/quick/by_topic_contains")
    public ResponseEntity<ServiceResponse> getListByTopicContains(
            @RequestParam String contains, @ModelAttribute @Valid PageRequestModel pageRequestModel) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(feedbackService.getListByTopicContains(contains, pageRequestModel, FeedbackQuickProjection.class));
    }

    @Secured({RoleConst.Name.STAFF, RoleConst.Name.SUPER_ADMIN})
    @GetMapping("/get/list/quick/by_content_contains")
    public ResponseEntity<ServiceResponse> getListByContentContains(
            @RequestParam String contains, @ModelAttribute @Valid PageRequestModel pageRequestModel) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(feedbackService.getListByContentContains(contains, pageRequestModel, FeedbackQuickProjection.class));
    }

    @PostMapping("/create")
    public ResponseEntity<ServiceResponse> create(
            @RequestBody @Valid FeedbackCreateRequestModel model) {
        return ResponseBuilder.status(HttpStatus.CREATED)
                .body(feedbackService.create(model));
    }

    @Secured({RoleConst.Name.STAFF, RoleConst.Name.SUPER_ADMIN})
    @PutMapping("/update/reviewed")
    public ResponseEntity<ServiceResponse> updateReviewed(
            @RequestParam UUID id, @RequestParam Boolean reviewed) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(feedbackService.updateReviewed(id, reviewed));
    }

}
