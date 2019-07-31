package biz.neustar.ultra.rest.main.auth;

import biz.neustar.ultra.rest.client.exception.UltraClientErrors;
import biz.neustar.ultra.rest.client.util.JsonUtils;
import biz.neustar.ultra.rest.dto.TokenResponse;
import biz.neustar.ultra.rest.main.ClientData;
import biz.neustar.ultra.rest.main.UltraRestClient;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.representation.Form;
import org.apache.http.HttpStatus;

import java.io.IOException;

/**
 * OAuth 2.0 implementation of AddAuth.
 * <p>
 * User provides the initial access token, refresh token, the auth URL, and an optional Callback.  Initial access token
 * acquisition is out of scope for this implementation.
 */
public class OAuth implements AddAuth {
    private static final String AUTHORIZATION = "Authorization";
    private final String authUrl;
    private final Callback callback;
    private String accessToken;
    private String refreshToken;

    public OAuth(String accessToken, String refreshToken, String authUrl, Callback callback) {
        this.authUrl = authUrl;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.callback = callback;
    }

    @Override
    public WebResource.Builder addAuth(WebResource.Builder builder) {
        return builder.header(AUTHORIZATION, "Bearer " + accessToken);
    }

    @Override
    public boolean refreshAuth(UltraRestClient client) {
        Form formData = new Form();
        formData.add("grant_type", "refresh_token");
        formData.add("refresh_token", refreshToken);
        ClientData clientData = client.post(authUrl, formData, false);
        // Use the returned token to setup an oauth client
        if (HttpStatus.SC_OK == clientData.getStatus()) {
            try {
                TokenResponse tokenResponse = JsonUtils.jsonToObject(clientData.getBody(), TokenResponse.class);
                accessToken = tokenResponse.getAccessToken();
                refreshToken = tokenResponse.getRefreshToken();
                if (callback != null) {
                    callback.tokensUpdated(accessToken, refreshToken);
                }
            } catch (IOException e) {
                return UltraClientErrors.castToUltraClientException(e, Boolean.class);
            }
            return true;
        } else {
            return UltraClientErrors.throwUltraClientException(clientData, Boolean.class);
        }
    }

    /**
     * Provides a way for higher-level code to get notification that the access token and refresh token have changed.
     * This allows code to, for example, store the changed values in a property file for later re-use.
     */
    public interface Callback {
        /**
         * Invoked by refreshAuth() whenever a new accessToken and refreshToken are returned by the auth server.
         *
         * @param accessToken  The new access token
         * @param refreshToken The new refresh token.
         */
        void tokensUpdated(String accessToken, String refreshToken);
    }
}
