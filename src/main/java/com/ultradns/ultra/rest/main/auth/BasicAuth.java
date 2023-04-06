package com.ultradns.ultra.rest.main.auth;

import com.ultradns.ultra.rest.main.UltraRestClient;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;

/**
 * Basic Auth implementation of AddAuth.
 * <p>
 * User provides the username and password required for Basic Auth.
 */
public class BasicAuth implements AddAuth {
    private final String user;
    private final String password;

    public BasicAuth(String user, String password) {
        this.user = user;
        this.password = password;
    }

    @Override
    public WebResource.Builder addAuth(WebResource.Builder builder) {
        String encoded = Base64.encodeBase64String(StringUtils.getBytesUtf8(user + ":" + password));
        return builder.header("Authorization", "Basic " + encoded);
    }

    @Override
    public boolean refreshAuth(UltraRestClient client) {
        return false;
    }
}
