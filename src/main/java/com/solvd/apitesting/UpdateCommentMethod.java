package com.solvd.apitesting;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

@Endpoint(url = "${config.env.url}/repos/TLohinava/underground-db/comments/87821125", methodType = HttpMethodType.PATCH)
@RequestTemplatePath(path = "api/users/patch/rq.json")
@ResponseTemplatePath(path = "api/users/patch/rs.json")
public class UpdateCommentMethod extends AbstractApiMethodV2 {

    public UpdateCommentMethod(){
        setHeaders("Authorization=Bearer " + Configuration.getEnvArg("token"));
    }

}