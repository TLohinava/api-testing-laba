package com.solvd.apitesting;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;

@Endpoint(url = "${config.env.url}/repos/TLohinava/underground-db/comments/87750662", methodType = HttpMethodType.PATCH)
@RequestTemplatePath(path = "api/users/get/rq.json")
@ResponseTemplatePath(path = "null")
public class UpdateCommentMethod extends AbstractApiMethodV2 {
}