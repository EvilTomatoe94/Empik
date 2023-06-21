package com.recruitment.exercise.domain.users;

public interface UserRepository {
    void updateUserCallsCounter(String login);
}
