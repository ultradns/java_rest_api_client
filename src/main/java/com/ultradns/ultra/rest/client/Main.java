package com.ultradns.ultra.rest.client;

import com.ultradns.ultra.rest.main.auth.OAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/*
 * User: jbodner
 * Date: 12/19/13
 * Time: 7:27 PM
 *
 * Copyright 2023 Vercara LLC. All rights reserved.
 * Vercara, the Vercara logo and related names and logos are registered
 * trademarks, service marks or tradenames of Vercara LLC. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
public final class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    private static final int ARGS_WITH_CREDENTIALS_AND_URL = 3;

    // For later use
    private static String refreshToken;
    private static String accessToken;

    private static String baseUrl;

    private Main() {

    }

    private static void readUserPassword(String fileName) {
        try (FileInputStream fis = new FileInputStream(fileName)) {
            Properties props = new Properties();
            props.load(fis);
            baseUrl = props.getProperty("baseUrl");
        } catch (IOException e) {
            System.out.printf("unable to load from file %s", fileName);
            System.out.println();
            e.printStackTrace();
        }
    }

    private static void writeUserPassword(String fileName, String user, String password, String url) {
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            Properties props = new Properties();
            props.setProperty("user", user);
            props.setProperty("password", password);
            props.setProperty("baseUrl", url);
            props.store(fos, "");
        } catch (IOException e) {
            System.out.printf("unable to load from file %s", fileName);
            System.out.println();
            e.printStackTrace();
        }
    }

    private static void readTokens(String fileName) {
        try (FileInputStream fis = new FileInputStream(fileName)) {
            Properties props = new Properties();
            props.load(fis);
            accessToken = props.getProperty("accessToken");
            refreshToken = props.getProperty("refreshToken");
        } catch (IOException e) {
            System.out.printf("unable to load from file %s", fileName);
            System.out.println();
            e.printStackTrace();
        }
    }

    private static void writeTokens(String fileName, String inputAccessToken, String inputRefreshToken) {
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            Properties props = new Properties();
            props.setProperty("accessToken", inputAccessToken);
            props.setProperty("refreshToken", inputRefreshToken);
            props.store(fos, "");
        } catch (IOException e) {
            System.out.printf("unable to write to file %s", fileName);
            System.out.println();
            e.printStackTrace();
        }
    }

    public static void main(String... args) {
        RestApiClient restApiClient = null;
        if (args.length == 0) {
            //try to load from property files
            restApiClient = getRestApiClient();
        }

        if (args.length == ARGS_WITH_CREDENTIALS_AND_URL) {
            restApiClient = getRestApiClient(args);
        }

        if (restApiClient == null) {
            System.err.println("Expected parameters: username password server_base_url");
            System.err.println("Example: my_user my_password https://api.ultradns.com");
            System.exit(1);
        }

        //do your REST API work here...for example
        try {
            System.out.println(restApiClient.createPrimaryZone("account_name", "zone.name.invalid"));
        } catch (Exception e) {
            LOG.error("Exception while running REST API Client", e);
        }
    }

    private static RestApiClient getRestApiClient(String... args) {
        RestApiClient restApiClient;
        writeUserPassword("rest_user.txt", args[0], args[1], args[2]);
        restApiClient = RestApiClient.buildRestApiClientWithUidPwd(args[0], args[1], args[2], new OAuth.Callback() {
            @Override
            public void tokensUpdated(String newAccessToken, String newRefreshToken) {
                writeTokens("rest_tokens.txt", newAccessToken, newRefreshToken);
            }
        });
        return restApiClient;
    }

    private static RestApiClient getRestApiClient() {
        RestApiClient restApiClient = null;
        readTokens("rest_tokens.txt");
        readUserPassword("rest_user.txt");
        if (accessToken != null && refreshToken != null && baseUrl != null) {
            restApiClient = RestApiClient.buildRestApiClientWithTokens(accessToken, refreshToken, baseUrl,
                    new OAuth.Callback() {
                        @Override
                        public void tokensUpdated(String newAccessToken, String newRefreshToken) {
                            writeTokens("rest_tokens.txt", newAccessToken, newRefreshToken);
                        }
                    });
        }
        return restApiClient;
    }
}
