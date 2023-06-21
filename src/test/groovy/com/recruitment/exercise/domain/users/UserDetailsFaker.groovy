package com.recruitment.exercise.domain.users

class UserDetailsFaker {

    static UserDetails USER_DETAILS = UserDetails.of(UserGitDetailsFaker.USER_GIT_DETAILS, new BigDecimal("8"))
}
