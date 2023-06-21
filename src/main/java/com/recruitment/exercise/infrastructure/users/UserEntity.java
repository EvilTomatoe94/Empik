package com.recruitment.exercise.infrastructure.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
@SuperBuilder(toBuilder = true)
public class UserEntity {

    @Column(name = "login", nullable = false)
    @Id
    private String login;

    @Column(name = "request_count", nullable = false)
    private Long requestCount;
}
