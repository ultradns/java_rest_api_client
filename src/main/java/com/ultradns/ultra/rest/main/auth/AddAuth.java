package com.ultradns.ultra.rest.main.auth;

import com.ultradns.ultra.rest.main.UltraRestClient;
import com.sun.jersey.api.client.WebResource;

/**
 * Provide authorization logic for a REST request.
 * <p>
 * Implementations of this interface are passed to the constructor of UltraRestClient. Their primary purpose is to
 * decorate the request with authorization information as it is being sent to the REST server.  It also provides a way
 * to refresh authorization information for schemes that expire credentials (such as OAuth 2.0)
 */
public interface AddAuth {
    /**
     * Add authorization credentials to a request to a REST server.
     *
     * @param builder A WebResource.Builder that refers to a remote resource.
     * @return The passed-in Builder, or a Builder that contains the information supplied before the method call, in
     *         addition to any information added by the method call.
     */
    WebResource.Builder addAuth(WebResource.Builder builder);

    /**
     * Reacquires authorization credentials.
     *
     * @param client An UltraRestClient for connecting to the authorization server.
     * @return true if the credentials were refreshed, false otherwise.  If using an authorization scheme that does not
     *         require refresh, return false.
     */
    boolean refreshAuth(UltraRestClient client);
}
