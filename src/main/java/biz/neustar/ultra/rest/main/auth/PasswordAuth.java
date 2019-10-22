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
 * PasswordAuth implementation of AddAuth.
 * <p>
 * User provides the initial access token, username, the auth URL, and the Callback.
 */
public class PasswordAuth implements AddAuth {
    private static final String AUTHORIZATION = "Authorization";
    private final String user;
    private final String authUrl;
    private String accessToken;
    private final Callback callback;

    public PasswordAuth(String user, String authUrl, String accessToken, Callback callback) {
        this.user = user;
        this.authUrl = authUrl;
        this.accessToken = accessToken;
        this.callback = callback;
    }

    @Override
    public WebResource.Builder addAuth(WebResource.Builder builder) {
        return builder.header(AUTHORIZATION, "Bearer " + accessToken);
    }

    @Override
    public boolean refreshAuth(UltraRestClient client) {
        Form formData = new Form();
        formData.add("grant_type", "password");
        formData.add("username", user);
        formData.add("password", new String(callback.getPassword()));
        ClientData clientData = client.post(authUrl, formData, false);
        // Use the returned token to setup an oauth client
        if (HttpStatus.SC_OK == clientData.getStatus()) {
            try {
                TokenResponse tokenResponse = JsonUtils.jsonToObject(clientData.getBody(), TokenResponse.class);
                accessToken = tokenResponse.getAccessToken();
            } catch (IOException e) {
                return UltraClientErrors.castToUltraClientException(e, Boolean.class);
            }
            return true;
        } else {
            return UltraClientErrors.throwUltraClientException(clientData, Boolean.class);
        }
    }

    public interface Callback {
        char[] getPassword();
    }
}
