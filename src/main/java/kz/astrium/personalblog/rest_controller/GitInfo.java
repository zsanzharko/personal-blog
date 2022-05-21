package kz.astrium.personalblog.rest_controller;


import kz.astrium.personalblog.handler.accountInformation.GitHubHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/github")
public class GitInfo {
    private final GitHubHandler gitHubHandler;

    @Autowired
    public GitInfo(GitHubHandler gitHubHandler) {
        this.gitHubHandler = gitHubHandler;
    }

    @GetMapping("/user/{username}")
    public String getInfo(@PathVariable final String username) {
      return  gitHubHandler.getAccountInfo(username);
    }
}
