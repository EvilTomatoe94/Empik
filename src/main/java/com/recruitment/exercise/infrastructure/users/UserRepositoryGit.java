package com.recruitment.exercise.infrastructure.users;

import com.recruitment.exercise.domain.exceptions.ResourceNotFoundException;
import com.recruitment.exercise.domain.users.UserGitDetails;
import com.recruitment.exercise.domain.users.UserGitRepository;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.recruitment.exercise.domain.exceptions.ResourceNotFoundExceptionType.USER_NOT_FOUND;
import static lombok.AccessLevel.PACKAGE;

@Service
@RequiredArgsConstructor(access = PACKAGE)
@Slf4j
public class UserRepositoryGit implements UserGitRepository {

    private final static String ERROR_MESSAGE = "Unknown exception occurred during git fetch. Message: {}";
    private final UserGitFeignClient userGitFeignClient;

    @Override
    public UserGitDetails getUserGitData(String login) {
        UserGitDetails userGitDetails = null;
        try {
            userGitDetails = userGitFeignClient.getUserGitData(login);
        } catch (FeignException.NotFound e) {
            throw new ResourceNotFoundException(USER_NOT_FOUND);
        }

        return userGitDetails;
    }
}
