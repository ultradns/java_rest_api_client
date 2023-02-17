/*
 * Copyright 2023 Vercara LLC. All rights reserved.
 * Vercara, the Vercara logo and related names and logos are registered
 * trademarks, service marks or tradenames of Vercara LLC. All other
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
