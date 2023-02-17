package com.ultradns.ultra.rest.dto;

import com.ultradns.ultra.rest.constants.UltraRestSharedConstant;

/*
 * User: jbodner
 * Date: 6/13/13
 * Time: 10:08 PM
 *
 * Copyright 2023 Vercara LLC. All rights reserved.
 * Vercara, the Vercara logo and related names and logos are registered
 * trademarks, service marks or tradenames of Vercara LLC. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
public class Status {
    public static final Status SUCCESSFUL = new Status(UltraRestSharedConstant.SUCCESSFUL.getValue());
    public static final Status PENDING = new Status(UltraRestSharedConstant.PENDING.getValue());

    private String message;

    /**
     * Default constructor.  The preferred constructor is the one with a parameter, but some deserialization situations
     * may require an empty constructor.  The message field should always be populated.
     */
    public Status() {
        //intentionally empty
    }

    public Status(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Status status = (Status) o;

        return !(message != null ? !message.equals(status.message) : status.message != null);
    }

    @Override
    public int hashCode() {
        return message != null ? message.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Status{" + "message='" + message + '\'' + '}';
    }
}
