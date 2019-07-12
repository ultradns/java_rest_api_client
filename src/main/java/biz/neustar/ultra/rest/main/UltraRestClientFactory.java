package biz.neustar.ultra.rest.main;

import biz.neustar.ultra.rest.client.util.JsonUtils;
import biz.neustar.ultra.rest.dto.TokenResponse;
import biz.neustar.ultra.rest.main.auth.AddAuth;
import biz.neustar.ultra.rest.main.auth.BasicAuth;
import biz.neustar.ultra.rest.main.auth.NoAuth;
import biz.neustar.ultra.rest.main.auth.OAuth;
import com.sun.jersey.api.representation.Form;
import org.apache.http.HttpStatus;

import java.io.IOException;

/*
 * User: jbodner
 * Date: 12/30/13
 * Time: 1:20 PM
 *
 * Copyright 2000-2012 NeuStar, Inc. All rights reserved.
 * NeuStar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of NeuStar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
public final class UltraRestClientFactory {

    private static final AddAuth NO_AUTH = new NoAuth();

    private UltraRestClientFactory() {
        //Prevents instantiation
    }

    public static UltraRestClient createRestClientNoAuth(String baseUrl) {
        return new UltraRestClient(baseUrl, NO_AUTH);
    }

    public static UltraRestClient createRestClientBasicAuth(String baseUrl, final String user, final String password) {
        return new UltraRestClient(baseUrl, new BasicAuth(user, password));
    }

    public static UltraRestClient createRestClientOAuthUserPwd(String baseUrl, String user, String password,
            String authUrl) {
        return createRestClientOAuthUserPwdCallback(baseUrl, user, password, authUrl, null);

    }

    public static UltraRestClient createRestClientOAuthUserPwdCallback(String baseUrl, String user, String password,
            String authUrl, OAuth.Callback callback) {
        //first generate the access token and bearer tokens
        UltraRestClient firstClient = createRestClientNoAuth(baseUrl);
        Form formData = new Form();
        formData.add("grant_type", "password");
        formData.add("username", user);
        formData.add("password", password);
        ClientData clientData = firstClient.post(authUrl, formData);
        // Use the returned token to setup an oauth client
        if (HttpStatus.SC_OK != clientData.getStatus()) {
            throw new RuntimeException("Status: " + clientData.getStatus() + ", Description: " + clientData.getBody());
        }
        try {
            TokenResponse tokenResponse = JsonUtils.jsonToObject(clientData.getBody(), TokenResponse.class);
            String accessToken = tokenResponse.getAccessToken();
            String refreshToken = tokenResponse.getRefreshToken();
            if (callback != null) {
                callback.tokensUpdated(accessToken, refreshToken);
            }
            return createRestClientOAuthTokensCallback(baseUrl, accessToken, refreshToken, authUrl, callback);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static UltraRestClient createRestClientOAuthTokens(String baseUrl, final String accessToken,
            final String refreshToken, final String authUrl) {
        return new UltraRestClient(baseUrl, new OAuth(accessToken, refreshToken, authUrl, null));
    }

    public static UltraRestClient createRestClientOAuthTokensCallback(String baseUrl, final String accessToken,
            final String refreshToken, final String authUrl, OAuth.Callback callback) {
        return new UltraRestClient(baseUrl, new OAuth(accessToken, refreshToken, authUrl, callback));
    }

}
