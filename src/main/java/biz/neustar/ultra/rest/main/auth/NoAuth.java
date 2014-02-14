package biz.neustar.ultra.rest.main.auth;

import biz.neustar.ultra.rest.main.UltraRestClient;
import com.sun.jersey.api.client.WebResource;

/**
 *  Dummy implementation of AddAuth that does nothing.
 */
public class NoAuth implements AddAuth {
    @Override
    public WebResource.Builder addAuth(WebResource.Builder builder) {
        return builder;
    }

    @Override
    public boolean refreshAuth(UltraRestClient client) {
        return false;
    }
}
