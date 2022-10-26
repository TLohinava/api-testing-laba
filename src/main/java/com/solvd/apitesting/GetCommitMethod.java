package com.solvd.apitesting;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class GetCommitMethod extends AbstractApiMethodV2 {

    public GetCommitMethod(String username, String repo) {
        super(null, "/api/users/get/rs-commits.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("url"));
        replaceUrlPlaceholder("username", username);
        replaceUrlPlaceholder("repo", repo);
    }

}