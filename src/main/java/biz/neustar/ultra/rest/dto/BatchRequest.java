/*
 * User: nupadhyay
 * Date: Mar 25, 2014
 * Time: 12:58:04 PM
 *
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved.
 * NeuStar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of NeuStar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
package biz.neustar.ultra.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;

/**
 * Batch request.
 */
@JsonInclude(Include.NON_NULL)
public class BatchRequest implements Serializable {

    private Method method;
    private String uri;
    private Object body;

    public BatchRequest() {
        super();
    }

    public BatchRequest(Method method, String uri, Object body) {
        super();
        this.method = method;
        this.uri = uri;
        this.body = body;
    }

    /**
     * Get method.
     *
     * @return the method
     */
    public Method getMethod() {
        return method;
    }

    /**
     * Set method.
     *
     * @param method the method to set
     */
    public void setMethod(Method method) {
        this.method = method;
    }

    /**
     * Get url.
     *
     * @return the uri
     */
    public String getUri() {
        return uri;
    }

    /**
     * Set url.
     *
     * @param uri the uri to set
     */
    public void setUri(String uri) {
        this.uri = uri;
    }

    /**
     * Get body.
     *
     * @return the body
     */
    public Object getBody() {
        return body;
    }

    /**
     * Set body.
     *
     * @param body the body to set
     */
    public void setBody(Object body) {
        this.body = body;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public final String toString() {
        return MoreObjects.toStringHelper(this)
                .add("body", getBody())
                .add("method", getMethod())
                .add("uri", getUri())
                .toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(getBody(), getMethod(), getUri());
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public final boolean equals(final Object obj) {
        boolean isEqual = true;
        if (!(obj instanceof BatchRequest)) {
            return false;
        }
        final BatchRequest other = (BatchRequest) obj;
        isEqual = Objects.equal(getBody(), other.getBody()) && Objects.equal(getMethod(), other.getMethod())
                && Objects.equal(getUri(), other.getUri());
        return isEqual;
    }

    /**
     * Enum for HTTP method type.
     */
    public enum Method {
        POST,
        PUT,
        PATCH,
        GET,
        DELETE
    }
}
