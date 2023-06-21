package com.recruitment.exercise.domain.users;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor(staticName = "of")
@Getter
public class UserDetails {

    private final UserGitDetails userGitDetails;

    private final BigDecimal calculations;
}
