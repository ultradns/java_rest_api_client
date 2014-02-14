package biz.neustar.ultra.rest.dto;

/*
 * User: jbodner
 * Date: 9/30/13
 * Time: 3:27 PM
 *
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved.
 * NeuStar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of NeuStar, Inc. All other
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
        return "Version{" +
                "version='" + version + '\'' +
                '}';
    }
}
