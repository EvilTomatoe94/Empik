package com.recruitment.exercise.infrastructure.users;


public class UserEntityFactory {

    public static UserEntity create(String login) {
        return UserEntity.builder()
                .login(login)
                .requestCount(1L)
                .build();
    }

    public static UserEntity update(UserEntity userEntity) {
        return userEntity.toBuilder()
                .requestCount(userEntity.getRequestCount() + 1L)
                .build();
    }
}
