package com.ultradns.ultra.rest.dto;

/*
 * User: jbodner
 * Date: 4/18/14
 * Time: 3:20 PM
 *
 * Copyright 2000-2014 NeuStar, Inc. All rights reserved.
 * NeuStar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of NeuStar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
public class Guid {
    private String guid;

    public Guid() {
        super();
    }

    public Guid(String guid) {
        this.guid = guid;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    @Override
    public String toString() {
        return "Guid{" + "guid='" + guid + '\'' + '}';
    }
}
