package biz.neustar.ultra.rest.client;

import biz.neustar.ultra.rest.main.auth.OAuth;
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
 * Copyright 2000-2012 NeuStar, Inc. All rights reserved.
 * NeuStar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of NeuStar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
public class Main {
    private final static Logger LOG = LoggerFactory.getLogger(Main.class);

    // TODO - For later use
    private static String refreshToken;
    private static String accessToken;

    private static String user;
    private static String password;
    private static String baseUrl;

    private static void readUserPassword(String fileName) {
        try {
            Properties props = new Properties();
            props.load(new FileInputStream(fileName));
            user = props.getProperty("user");
            password = props.getProperty("password");
            baseUrl = props.getProperty("baseUrl");
        } catch (IOException e) {
            System.out.printf("unable to load from file %s\n", fileName);
            e.printStackTrace();
        }
    }

    private static void writeUserPassword(String fileName, String user, String password, String url) {
        try {
            Properties props = new Properties();
            props.setProperty("user", user);
            props.setProperty("password", password);
            props.setProperty("baseUrl", url);
            props.store(new FileOutputStream(fileName), "");
        } catch (IOException e) {
            System.out.printf("unable to load from file %s\n", fileName);
            e.printStackTrace();
        }
    }

    private static void readTokens(String fileName) {
        try {
            Properties props = new Properties();
            props.load(new FileInputStream(fileName));
            accessToken = props.getProperty("accessToken");
            refreshToken = props.getProperty("refreshToken");
        } catch (IOException e) {
            System.out.printf("unable to load from file %s\n", fileName);
            e.printStackTrace();
        }
    }

    private static void writeTokens(String fileName, String accessToken, String refreshToken) {
        try {
            Properties props = new Properties();
            props.setProperty("accessToken", accessToken);
            props.setProperty("refreshToken", refreshToken);
            props.store(new FileOutputStream(fileName), "");
        } catch (IOException e) {
            System.out.printf("unable to write to file %s\n", fileName);
            e.printStackTrace();
        }
    }

    private Main() {

    }

    public static void main(String[] args) {
        RestApiClient restApiClient = null;
        if(args.length == 0) {
            //try to load from property files
            readTokens("rest_tokens.txt");
            readUserPassword("rest_user.txt");
            if (accessToken != null && refreshToken != null && baseUrl != null) {
                restApiClient = RestApiClient.buildRestApiClientWithTokens(accessToken, refreshToken, baseUrl, new OAuth.Callback() {
                    @Override
                    public void tokensUpdated(String newAccessToken, String newRefreshToken) {
                        writeTokens("rest_tokens.txt", newAccessToken, newRefreshToken);
                    }
                });
            }
        }

        if (args.length == 3) {
            writeUserPassword("rest_user.txt", args[0], args[1], args[2]);
            restApiClient = RestApiClient.buildRestApiClientWithUidPwd(args[0], args[1], args[2], new OAuth.Callback() {
                @Override
                public void tokensUpdated(String newAccessToken, String newRefreshToken) {
                    writeTokens("rest_tokens.txt", newAccessToken, newRefreshToken);
                }
            });
        }

        if(restApiClient == null) {
            System.err.println("Expected parameters: username password server_base_url");
            System.err.println("Example: my_user my_password http://restapi-useast1b01-01.qa.ultradns.net:8080/");
            System.exit(1);
        }

        //System.out.println(restApiClient.getStatus());
        //System.out.println(restApiClient.getVersion());
        try {
            //System.out.println(restApiClient.getZoneMetadata("domain1999.com"));
            //System.out.println(restApiClient.getZonesOfAccount("selautomation10", "zone_type:PRIMARY", "0", "1000", "NAME", "true"));
            System.out.println(restApiClient.createPrimaryZone("selautomation10", "narayantest8.biz"));
            //for (int i=0; i<200; i++)
            //    restApiClient.getZoneMetadata("narayantest7.biz");

            //doesnt work
            //System.out.println(restApiClient.getRRSets("narayantest.biz", "owner:selautomation10", "0", "1000", "OWNER", "true"));
            //estApiClient.deleteZone("narayantest6.biz");
        } catch (Exception e) {
            LOG.error("Exception while running REST API Client",e);
        }
    }
}
