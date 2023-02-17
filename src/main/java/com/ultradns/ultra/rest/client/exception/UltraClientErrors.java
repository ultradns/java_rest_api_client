package com.ultradns.ultra.rest.client.exception;

import com.ultradns.ultra.rest.client.util.JsonUtils;
import com.ultradns.ultra.rest.dto.UltraError;
import com.ultradns.ultra.rest.main.ClientData;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import org.apache.commons.httpclient.HttpStatus;

import java.io.IOException;
import java.util.List;

/*
 * User: kbhandar
 * Date: 2019-07-30
 *
 * Copyright 2023 Vercara LLC. All rights reserved.
 * Vercara, the Vercara logo and related names and logos are registered
 * trademarks, service marks or tradenames of Vercara LLC. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
public final class UltraClientErrors {

    private UltraClientErrors() { /* util class */ }

    public static void checkClientData(ClientData clientData) {
        if (clientData.getStatus() >= HttpStatus.SC_BAD_REQUEST) {
            throwUltraClientException(clientData, Void.class);
        }
    }

    public static <T> T throwUltraClientException(ClientData clientData, final Class<T> dummy) {
        // Ultra REST APIs can either return list of errors or single error
        JsonNode jsonNode = null;
        try {
            jsonNode = JsonUtils.readTree(clientData.getBody());
        } catch (IOException e) {
            return castToUltraClientException(e, dummy);
        }

        if (jsonNode.isArray() && jsonNode.size() > 0 && jsonNode.get(0).get("errorCode") != null) {
            throw new UltraClientException(clientData.getStatus(),
                    JsonUtils.convertValue(jsonNode, new TypeReference<List<UltraError>>() {
                    }));
        } else if (jsonNode.get("errorCode") != null) {
            throw new UltraClientException(clientData.getStatus(),
                    Lists.newArrayList(JsonUtils.convertValue(jsonNode, UltraError.class)));
        } else { // unexpected return type
            throw new UltraClientException(clientData.getStatus(),
                    Lists.newArrayList(new UltraError(clientData.getStatus(), clientData.getBody())));
        }
    }

    public static <T> T castToUltraClientException(Exception e, final Class<T> dummy) {
        throw new UltraClientException(HttpStatus.SC_INTERNAL_SERVER_ERROR, Lists.newArrayList(
                new UltraError(HttpStatus.SC_INTERNAL_SERVER_ERROR,
                        HttpStatus.getStatusText(HttpStatus.SC_INTERNAL_SERVER_ERROR) + ": " + e.getMessage())), e);
    }
}
