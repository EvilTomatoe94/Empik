package com.recruitment.exercise.infrastructure.user

import com.recruitment.exercise.infrastructure.users.UserEntity

import static com.recruitment.exercise.domain.users.UserGitDetailsFaker.USER_GIT_DETAILS

class UserEntityFaker {

    static UserEntity EXISTING_USER = UserEntity.builder()
            .requestCount(1)
            .login(USER_GIT_DETAILS.login)
            .build()
}
