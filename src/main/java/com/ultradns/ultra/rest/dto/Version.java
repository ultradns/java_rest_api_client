package com.ultradns.ultra.rest.dto;

/*
 * Copyright 2023 Vercara LLC. All rights reserved.
 * Vercara, the Vercara logo and related names and logos are registered
 * trademarks, service marks or tradenames of Vercara LLC. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
public class Version {
    private String version;

    public Version() {
        super();
    }

    public Version(String version) {
        super();
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return "Version{" + "version='" + version + '\'' + '}';
    }
}
