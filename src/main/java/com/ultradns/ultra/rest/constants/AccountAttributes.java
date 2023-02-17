/*
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved.
 * NeuStar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of NeuStar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package com.ultradns.ultra.rest.constants;

/**
 * An enum that represents account level attributes.
 */
public enum AccountAttributes {

    /**
     * All attributes of the account.
     */
    ALL,

    /**
     * NO attributes of the account.
     */
    NONE,

    /**
     * TSIG.
     */
    TSIG,

    /**
     * Restrict IPs.
     */
    IP_RANGE,

    /**
     * Notify IPs.
     */
    NOTIFY_IP;
}
