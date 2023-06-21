package com.recruitment.exercise.domain.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;


@AllArgsConstructor
@Getter
@Builder
public class UserGitDetails {

    private final Long id;

    private final String login;

    private final String type;

    @JsonProperty("avatar_url")
    private final String avatarUrl;

    @JsonProperty("created_at")
    private final LocalDateTime createdAt;

    @JsonProperty("public_repos")
    private final Integer publicRepos;

    private final Integer followers;
}
