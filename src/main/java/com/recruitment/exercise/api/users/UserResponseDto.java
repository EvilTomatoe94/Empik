package com.recruitment.exercise.api.users;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static io.swagger.annotations.ApiModelProperty.AccessMode.*;

@Builder
@Getter
public class UserResponseDto {

    @ApiModelProperty(required = true, example = "1", accessMode = READ_ONLY)
    private final Long id;

    @ApiModelProperty(required = true, example = "programmer_94", accessMode = READ_ONLY)
    private final String login;

    @ApiModelProperty(required = true, example = "User", accessMode = READ_ONLY)
    private final String type;

    @ApiModelProperty(example = "https://avatars.githubusercontent.com/u/583231?v=4", accessMode = READ_ONLY)
    private final String avatarUrl;

    @ApiModelProperty(required = true, example = "2022-01-13", accessMode = READ_ONLY)
    private final LocalDateTime createdAt;

    @ApiModelProperty(required = true, example = "32", accessMode = READ_ONLY)
    private final BigDecimal calculations;

}
