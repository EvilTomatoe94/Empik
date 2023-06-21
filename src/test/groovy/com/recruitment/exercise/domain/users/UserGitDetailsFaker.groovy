package com.recruitment.exercise.domain.users

import com.recruitment.exercise.domain.users.UserGitDetails

import java.time.LocalDate
import java.time.LocalDateTime

import static java.time.LocalTime.*

class UserGitDetailsFaker {

    static UserGitDetails USER_GIT_DETAILS = UserGitDetails.builder()
            .id(1L)
            .avatarUrl("www.google.com")
            .createdAt(LocalDateTime.of(LocalDate.of(2003, 1, 31), MAX))
            .followers(15)
            .login("kamila.w")
            .publicRepos(2)
            .type("User")
            .build()
}
