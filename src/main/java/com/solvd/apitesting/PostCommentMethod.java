package com.solvd.apitesting;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;

public class PostCommentMethod extends AbstractApiMethodV2 {

    public PostCommentMethod() {
        super("/api/users/post/rq.json", "/api/users/post/rs.json", "api/users/user.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("url"));
        setHeaders("Authorization=Bearer " + R.CONFIG.get("token"));
    }
}