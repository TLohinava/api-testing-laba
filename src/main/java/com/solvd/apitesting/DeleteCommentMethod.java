package com.solvd.apitesting;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;

@Endpoint(url = "${config.env.url}/repos/TLohinava/underground-db/comments/87750662", methodType = HttpMethodType.DELETE)
public class DeleteCommentMethod extends AbstractApiMethodV2 {
}