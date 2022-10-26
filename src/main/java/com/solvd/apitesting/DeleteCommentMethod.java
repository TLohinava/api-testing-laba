package com.solvd.apitesting;

import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;

@Endpoint(url = "${config.env.url}/repos/${username}/${repo}/comments/${commentId}", methodType = HttpMethodType.DELETE)
@SuccessfulHttpStatus(status = HttpResponseStatusType.NO_CONTENT_204)
public class DeleteCommentMethod extends AuthorizationClass {

    public DeleteCommentMethod(String username, String repo, String commentId) {
        replaceUrlPlaceholder("username", username);
        replaceUrlPlaceholder("repo", repo);
        replaceUrlPlaceholder("commentId", commentId);
    }
}