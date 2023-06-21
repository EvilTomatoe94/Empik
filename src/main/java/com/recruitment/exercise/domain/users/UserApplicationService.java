package com.recruitment.exercise.domain.users;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static lombok.AccessLevel.PACKAGE;

@Service
@RequiredArgsConstructor(access = PACKAGE)
@Transactional
public class UserApplicationService {

    private final UserRepository userRepository;
    private final UserGitRepository userGitRepository;

    public UserDetails getUserDetails(String login) {
        UserGitDetails userGitDetails = userGitRepository.getUserGitData(login);
        userRepository.updateUserCallsCounter(login);

        return UserDetails.of(
                userGitDetails,
                makeCalculations(userGitDetails));
    }

    private BigDecimal makeCalculations(UserGitDetails userGitDetails) {
        return new BigDecimal(6)
                .divide(new BigDecimal(userGitDetails.getFollowers()), 6, RoundingMode.HALF_UP)
                .multiply(new BigDecimal(2 + userGitDetails.getPublicRepos()))
                .stripTrailingZeros();
    }
}
