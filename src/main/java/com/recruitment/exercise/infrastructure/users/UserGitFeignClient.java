package com.recruitment.exercise.infrastructure.users;

import com.recruitment.exercise.domain.users.UserGitDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(url = "${app.git.user.url}", name = "git-user")
public interface UserGitFeignClient {

    @RequestMapping("/{login}")
    UserGitDetails getUserGitData(@PathVariable String login);
}
