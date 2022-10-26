package com.solvd.apitesting;

import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;

@Endpoint(url = "${config.env.url}/repos/${username}/${repo}/comments/${commentId}", methodType = HttpMethodType.PATCH)
@RequestTemplatePath(path = "api/users/patch/rq.json")
@ResponseTemplatePath(path = "api/users/patch/rs.json")
public class UpdateCommentMethod extends AuthorizationClass {

    public UpdateCommentMethod(String username, String repo, String commentId) {
        replaceUrlPlaceholder("username", username);
        replaceUrlPlaceholder("repo", repo);
        replaceUrlPlaceholder("commentId", commentId);
    }
}