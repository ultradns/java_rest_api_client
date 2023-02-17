package com.ultradns.ultra.rest.constants;

/*
 * User: kbhandar
 * Date: 7/13/18
 *
 * Copyright 2018 Neustar, Inc. All rights reserved.
 * Neustar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of Neustar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
public enum PoolProbeStatus {
    OK(0),
    WARNING(1),
    CRITICAL(2),
    FAILED(3);

    private final int value;

    PoolProbeStatus(int value) {
        this.value = value;
    }

    public static PoolProbeStatus findBy(String value) {
        if (value != null) {
            int intVal = Integer.parseInt(value);
            return findByValue(intVal);
        }
        return null;
    }

    public static PoolProbeStatus findByValue(int value) {
        for (PoolProbeStatus status : PoolProbeStatus.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        return null;
    }

    public int getValue() {
        return this.value;
    }
}
