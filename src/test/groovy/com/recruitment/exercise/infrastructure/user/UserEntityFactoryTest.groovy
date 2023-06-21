package com.recruitment.exercise.infrastructure.user

import com.recruitment.exercise.infrastructure.users.UserEntity
import com.recruitment.exercise.infrastructure.users.UserEntityFactory
import spock.lang.Specification

import static com.recruitment.exercise.domain.users.UserGitDetailsFaker.*
import static com.recruitment.exercise.infrastructure.user.UserEntityFaker.*

class UserEntityFactoryTest extends Specification {

    def 'should create user entity'() {
        when:
        UserEntity userEntity = UserEntityFactory.create(USER_GIT_DETAILS.login)

        then:
        verifyAll(userEntity) {
            login == USER_GIT_DETAILS.login
            requestCount == 1
        }
    }

    def 'should update user entity with requestCount == 2'() {
        when:
        UserEntity userEntity = UserEntityFactory.update(EXISTING_USER)

        then:
        verifyAll(userEntity) {
            login == EXISTING_USER.login
            requestCount == 2
        }
    }
}
