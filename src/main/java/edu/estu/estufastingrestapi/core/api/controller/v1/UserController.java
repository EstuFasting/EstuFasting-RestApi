package edu.estu.estufastingrestapi.core.api.controller.v1;

import edu.estu.estufastingrestapi.core.api.common.Origin;
import edu.estu.estufastingrestapi.core.api.common.ResponseBuilder;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.LogExecutionTime;
import edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.Trimmed;
import edu.estu.estufastingrestapi.core.domain.response.abstraction.ApiResponse;
import edu.estu.estufastingrestapi.core.service.abstracts.UserService;
import edu.estu.estufastingrestapi.core.service.model.response.user.UserFullyJoinedProjection;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@LogExecutionTime
@Trimmed

@CrossOrigin(origins = Origin.LOCALHOST_3000)
@RestController
@RequestMapping("/api/v1/user")
@Api(tags = "User")
public class UserController {

    private final UserService userService;

    @GetMapping("/get/fully_joined/by_username")
    public ResponseEntity<ApiResponse> getByUsername(@RequestParam String username) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(userService.getFullyJoinedByUsername(username, UserFullyJoinedProjection.class));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ApiResponse> delete(@RequestParam UUID id) {
        return ResponseBuilder.status(HttpStatus.OK)
                .body(userService.delete(id));
    }

}
