package com.recruitment.exercise.domain.users

import com.recruitment.exercise.ApplicationBaseIT
import com.recruitment.exercise.infrastructure.users.UserEntity

import static UserDetailsFaker.USER_DETAILS
import static UserGitDetailsFaker.*


class UserApplicationServiceIT extends ApplicationBaseIT {

    def 'should get user details'() {
        given:
        userRepositoryGit.getUserGitData(USER_GIT_DETAILS.login) >> USER_GIT_DETAILS

        when:
        def result = userApplicationService.getUserDetails(USER_GIT_DETAILS.login)

        then:
        Optional<UserEntity> user = userJpaRepository.findById(USER_GIT_DETAILS.login)
        verifyAll(result) {
            user.isPresent()
            user.get().requestCount == 1
            result.userGitDetails.id == USER_DETAILS.userGitDetails.id
            result.userGitDetails.login == USER_DETAILS.userGitDetails.login
            result.userGitDetails.avatarUrl == USER_DETAILS.userGitDetails.avatarUrl
            result.userGitDetails.type == USER_DETAILS.userGitDetails.type
            result.userGitDetails.createdAt == USER_DETAILS.userGitDetails.createdAt
            result.calculations == new BigDecimal("1.6")
        }
    }

    def 'should update request count'() {
        given:
        userRepositoryGit.getUserGitData(USER_GIT_DETAILS.login) >> USER_GIT_DETAILS

        when:
        userApplicationService.getUserDetails(USER_GIT_DETAILS.login)
        userApplicationService.getUserDetails(USER_GIT_DETAILS.login)

        then:
        Optional<UserEntity> user = userJpaRepository.findById(USER_GIT_DETAILS.login)
        verifyAll {
            user.isPresent()
            user.get().requestCount == 2
        }
    }
}
