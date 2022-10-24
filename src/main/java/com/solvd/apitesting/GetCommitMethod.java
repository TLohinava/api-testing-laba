package com.solvd.apitesting;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class GetCommitMethod extends AbstractApiMethodV2 {
    public GetCommitMethod() {
        super("/api/users/get/rq.json", null);
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("url"));
    }
}