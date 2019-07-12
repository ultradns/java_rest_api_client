package biz.neustar.ultra.rest.dto;

/**
 * Copyright 2000-2015 NeuStar, Inc. All rights reserved. NeuStar, the Neustar logo and related names and logos are
 * registered trademarks, service marks or tradenames of NeuStar, Inc. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */

/**
 * Test Probe Result Details.
 */
public class TestProbeResDetails {

    /**
     * Host machine the test was run against.
     */
    private String host;

    /**
     * Status of the probe test.
     */
    private String status;

    /**
     * Result message.
     */
    private String message;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
