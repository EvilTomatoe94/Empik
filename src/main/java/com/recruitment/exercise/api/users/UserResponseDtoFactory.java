package com.recruitment.exercise.api.users;

import com.recruitment.exercise.domain.users.UserDetails;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PROTECTED;

@NoArgsConstructor(access = PROTECTED)
public class UserResponseDtoFactory {

    public static UserResponseDto create(UserDetails userDetails) {
        return UserResponseDto.builder()
                .id(userDetails.getUserGitDetails().getId())
                .login(userDetails.getUserGitDetails().getLogin())
                .type(userDetails.getUserGitDetails().getType())
                .avatarUrl(userDetails.getUserGitDetails().getAvatarUrl())
                .createdAt(userDetails.getUserGitDetails().getCreatedAt())
                .calculations(userDetails.getCalculations())
                .build();
    }
}
