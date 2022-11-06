package edu.estu.estufastingrestapi.core.api.controller.v1;

import edu.estu.estufastingrestapi.core.model.constants.Origin;
import edu.estu.estufastingrestapi.core.service.abstracts.UserService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor

@CrossOrigin(origins = Origin.LOCALHOST_3000)
@RestController
@RequestMapping("/api/v1/user")
@Api(tags = "User")
public class UserController {

    private final UserService userService;

}
