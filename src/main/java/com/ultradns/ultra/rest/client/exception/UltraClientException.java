package com.ultradns.ultra.rest.client.exception;
/*
 * Copyright Vercara, LLC. All rights reserved. Vercara, the Vercara logo and related names and logos are
 * registered trademarks, service marks or tradenames of Vercara, LLC. All other product names, company names, marks,
 * logos and symbols may be trademarks of their respective owners.
 */

import com.ultradns.ultra.rest.dto.UltraError;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class UltraClientException extends RuntimeException {

    private static final long serialVersionUID = -2299674268656112544L;
    private static final Logger LOGGER = LoggerFactory.getLogger(UltraClientException.class);

    private final int status;
    private final List<UltraError> errors;

    private Throwable throwable;

    public UltraClientException(int status, List<UltraError> errors) {
        this.status = status;
        this.errors = errors;
    }

    public UltraClientException(int status, List<UltraError> errors, Throwable throwable) {
        this.status = status;
        this.errors = errors;
        this.throwable = throwable;
    }

    public List<UltraError> getErrors() {
        return errors;
    }

    public int getStatus() {
        return status;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UltraClientException that = (UltraClientException) o;
        return status == that.status && Objects.equal(errors, that.errors) && Objects.equal(throwable, that.throwable);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(errors, status, throwable);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("errors", errors)
                .add("status", status)
                .add("throwable", throwable)
                .toString();
    }
}
