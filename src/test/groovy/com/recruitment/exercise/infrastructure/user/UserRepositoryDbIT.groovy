package com.recruitment.exercise.infrastructure.user

import com.recruitment.exercise.ApplicationBaseIT
import com.recruitment.exercise.infrastructure.users.UserEntity

import static com.recruitment.exercise.domain.users.UserGitDetailsFaker.*
import static com.recruitment.exercise.infrastructure.user.UserEntityFaker.*

class UserRepositoryDbIT extends ApplicationBaseIT {

    def 'should create user with requestCount == 1'() {
        when:
        userRepositoryDb.updateUserCallsCounter(USER_GIT_DETAILS.login)

        then:
        Optional<UserEntity> user = userJpaRepository.findById(USER_GIT_DETAILS.login)
        verifyAll() {
            user.isPresent()
            user.get().requestCount == 1
            user.get().login == USER_GIT_DETAILS.login
        }
    }

    def 'should update user with requestCount == 2'() {
        given:
        transactionTemplate.execute(status ->
                userJpaRepository.save(EXISTING_USER)
        )

        when:
        userRepositoryDb.updateUserCallsCounter(USER_GIT_DETAILS.login)

        then:
        Optional<UserEntity> user = userJpaRepository.findById(USER_GIT_DETAILS.login)
        verifyAll() {
            user.isPresent()
            user.get().requestCount == 2
            user.get().login == USER_GIT_DETAILS.login
        }
    }
}
