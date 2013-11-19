package biz.neustar.ultra.rest.client;

import biz.neustar.ultra.rest.main.UltraRestClient;

/**
 * Copyright 2012-2013 NeuStar, Inc. All rights reserved.
 * NeuStar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of NeuStar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */

public class RestApiClient {
    private final UltraRestClient _ultraRestClient;

    public static void main (String[] args){
        System.out.println("first check in");

    }

    public RestApiClient(String userName, String password, String url, String authUrl) {
        _ultraRestClient = UltraRestClient.createRestClientNoAuth(url);
    }

    public String getVersion() {
        return _ultraRestClient.get("/v1/version").getBody();
    }
}
