package com.ultradns.ultra.rest.client;

import java.util.Random;

/*
 * Copyright Vercara, LLC. All rights reserved.
 * Vercara, the Vercara logo and related names and logos are registered
 * trademarks, service marks or tradenames of Vercara, LLC. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
public class AbstractBaseRestApiClientTest {
    protected static final int MAX_PAGE_SIZE = 1000;

    protected static final String USER_NAME = System.getProperty("rest.username");
    protected static final String PASSWORD = System.getProperty("rest.password");
    protected static final String URL = System.getProperty("rest.url");

    protected static final RestApiClient REST_API_CLIENT = RestApiClient.buildRestApiClientWithUidPwd(USER_NAME,
            PASSWORD, URL, null);

    private static final Random random = new Random();

    protected String getRandomZoneName() {
        return System.currentTimeMillis() + random.nextInt() + "-foo.invalid.";
    }
}
