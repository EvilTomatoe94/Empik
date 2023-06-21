package com.recruitment.exercise.api.users;

import com.recruitment.exercise.domain.users.UserApplicationService;
import com.recruitment.exercise.domain.users.UserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static lombok.AccessLevel.PACKAGE;

@Component
@RequiredArgsConstructor(access = PACKAGE)
public class UserQueryHandler {

    private final UserApplicationService userApplicationService;

    public UserResponseDto handleGetUserGitData(String login) {
        final UserDetails userDetails = userApplicationService.getUserDetails(login);
        return UserResponseDtoFactory.create(userDetails);
    }
}
