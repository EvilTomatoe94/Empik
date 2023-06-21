package com.recruitment.exercise.infrastructure.users;

import com.recruitment.exercise.domain.users.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static lombok.AccessLevel.PACKAGE;

@Service
@RequiredArgsConstructor(access = PACKAGE)
public class UserRepositoryDb implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    @Override
    public synchronized void updateUserCallsCounter(String login) {
        UserEntity entity = userJpaRepository.findById(login)
                .map(UserEntityFactory::update)
                .orElseGet(() -> UserEntityFactory.create(login));
        userJpaRepository.save(entity);
    }
}
