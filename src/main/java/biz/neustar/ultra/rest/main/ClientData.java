package biz.neustar.ultra.rest.main;

import javax.ws.rs.core.MultivaluedMap;

/*
 * User: jbodner
 * Date: 7/9/13
 * Time: 1:23 PM
 *
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved.
 * NeuStar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of NeuStar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
public class ClientData {
    private final int status;
    private final String body;
    private final MultivaluedMap<String, String> headers;

    public ClientData(MultivaluedMap<String, String> headers, String body, int status) {
        this.headers = headers;
        this.body = body;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public String getBody() {
        return body;
    }

    public MultivaluedMap<String, String> getHeaders() {
        return headers;
    }

    @Override
    public String toString() {
        return "ClientData{" + "status=" + status + ", body='" + body + '\'' + ", headers=" + headers + '}';
    }
}
