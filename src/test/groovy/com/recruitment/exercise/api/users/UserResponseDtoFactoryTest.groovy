package com.recruitment.exercise.api.users

import spock.lang.Specification

import static com.recruitment.exercise.domain.users.UserDetailsFaker.*

class UserResponseDtoFactoryTest extends Specification {

    def 'should map UserDetails to UserResponseDto'() {
        when:
        UserResponseDto response = UserResponseDtoFactory.create(USER_DETAILS)

        then:
        verifyAll(response) {
            response.id == USER_DETAILS.userGitDetails.id
            response.login == USER_DETAILS.userGitDetails.login
            response.avatarUrl == USER_DETAILS.userGitDetails.avatarUrl
            response.type == USER_DETAILS.userGitDetails.type
            response.createdAt == USER_DETAILS.userGitDetails.createdAt
            response.calculations == USER_DETAILS.calculations
        }
    }
}
