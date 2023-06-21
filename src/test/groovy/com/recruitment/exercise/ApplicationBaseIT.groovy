package com.recruitment.exercise

import com.recruitment.exercise.domain.users.UserApplicationService
import com.recruitment.exercise.domain.users.UserRepository
import com.recruitment.exercise.infrastructure.users.UserGitFeignClient
import com.recruitment.exercise.infrastructure.users.UserJpaRepository
import com.recruitment.exercise.infrastructure.users.UserRepositoryDb
import com.recruitment.exercise.infrastructure.users.UserRepositoryGit
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.jdbc.Sql
import org.springframework.transaction.support.TransactionTemplate
import org.testcontainers.spock.Testcontainers
import spock.lang.Specification

import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD

@Testcontainers
@SpringBootTest(classes = TestContext.class)
@ActiveProfiles("tests")
@Sql(executionPhase = BEFORE_TEST_METHOD, scripts = [
        "classpath:/db/test-cleanup.sql"
])
class ApplicationBaseIT extends Specification {

    @SpringBean
    UserRepositoryGit userRepositoryGit = Mock()

    @Autowired
    UserApplicationService userApplicationService

    @Autowired
    UserJpaRepository userJpaRepository

    @Autowired
    UserRepositoryDb userRepositoryDb

    @Autowired
    TransactionTemplate transactionTemplate
}
