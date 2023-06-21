package com.recruitment.exercise.api.users;

import com.recruitment.exercise.domain.exceptions.RC;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.recruitment.exercise.domain.exceptions.RC.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
@Api(tags = "user")
public class UserQueryController {

    private final UserQueryHandler userQueryHandler;

    @GetMapping(value = "/{login}", produces = {"application/app-v1.0+json"})
    @ApiOperation(value = "Get user")
    @ApiResponses({
            @ApiResponse(code = OK, message = "Success"),
            @ApiResponse(code = RESOURCE_NOT_FOUND, message = "When user does not exist (USER_NOT_FOUND)")
    })
    public UserResponseDto getUserGitData(@PathVariable String login) {
        return userQueryHandler.handleGetUserGitData(login);
    }
}
