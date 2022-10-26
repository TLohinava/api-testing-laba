package com.solvd.apitesting;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.R;

public abstract class AuthorizationClass extends AbstractApiMethodV2 {

    public AuthorizationClass() {
        setHeaders("Authorization=Bearer " + R.CONFIG.get("token"));
    }

    public AuthorizationClass(String rqPath, String rsPath) {
        super(rqPath, rsPath);
        setHeaders("Authorization=Bearer " + R.CONFIG.get("token"));
    }
}