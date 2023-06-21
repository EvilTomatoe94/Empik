package com.recruitment.exercise.api.users

import com.fasterxml.jackson.core.type.TypeReference
import com.recruitment.exercise.ApplicationBaseFT
import com.recruitment.exercise.domain.exceptions.ResourceNotFoundException
import com.recruitment.exercise.domain.exceptions.ResourceNotFoundExceptionType

import static com.recruitment.exercise.domain.exceptions.ResourceNotFoundExceptionType.*
import static com.recruitment.exercise.domain.users.UserDetailsFaker.USER_DETAILS
import static com.recruitment.exercise.domain.users.UserGitDetailsFaker.USER_GIT_DETAILS
import static org.springframework.http.HttpStatus.OK
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get


class UserQueryControllerFT extends ApplicationBaseFT {

    def 'should return user details'() {
        given:
        userRepositoryGit.getUserGitData(USER_GIT_DETAILS.login) >> USER_GIT_DETAILS

        when:
        def response = mockMvc.perform(get("/users/${USER_DETAILS.userGitDetails.login}"))
                .andReturn().response

        then:
        def result = objectMapper.readValue(response.getContentAsString(), new TypeReference<UserResponseDto>() {})
        response.status == OK.value()
        verifyAll(result) {
            id == USER_DETAILS.userGitDetails.id
            login == USER_DETAILS.userGitDetails.login
            avatarUrl == USER_DETAILS.userGitDetails.avatarUrl
            type == USER_DETAILS.userGitDetails.type
            createdAt == USER_DETAILS.userGitDetails.createdAt
            calculations == new BigDecimal("1.6")
        }
    }

    def 'should return 464'() {
        given:
        userRepositoryGit.getUserGitData(USER_GIT_DETAILS.login) >> { throw new ResourceNotFoundException(USER_NOT_FOUND) }

        when:
        def response = mockMvc.perform(get("/users/${USER_DETAILS.userGitDetails.login}"))
                .andReturn().response

        then:
        response.status == 464
    }
}
