package com.solvd.apitesting;

import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class PostCommentMethod extends AuthorizationClass{

    public PostCommentMethod(String username, String sha, String repo) {
        super("/api/users/post/rq.json", "/api/users/post/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("url"));
        replaceUrlPlaceholder("username", username);
        replaceUrlPlaceholder("sha", sha);
        replaceUrlPlaceholder("repo", repo);
    }
}