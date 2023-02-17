package com.ultradns.ultra.rest.main;

/*
 * Copyright 2023 Vercara LLC. All rights reserved.
 * Vercara, the Vercara logo and related names and logos are registered
 * trademarks, service marks or tradenames of Vercara LLC. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */

import com.ultradns.ultra.rest.client.util.JsonUtils;
import com.ultradns.ultra.rest.main.auth.AddAuth;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.common.base.Charsets;
import com.google.common.io.ByteSource;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.representation.Form;
import com.sun.jersey.client.apache.ApacheHttpClient;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import com.sun.jersey.multipart.FormDataBodyPart;
import com.sun.jersey.multipart.FormDataMultiPart;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * Ultra Rest Client.
 *
 * @author ankitm.agarwal Copyright 2023 Vercara LLC. All rights reserved. Vercara, the Vercara logo and related
 *         names and logos are registered trademarks, service marks or tradenames of Vercara LLC. All other product
 *         names, company names, marks, logos and symbols may be trademarks of their respective owners.
 */
@SuppressWarnings("PMD.GodClass")
public final class UltraRestClient {

    /**
     * This application logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UltraRestClient.class);

    private static final String POST = "POST";
    private static final String GET = "GET";
    private static final String DELETE = "DELETE";
    private static final String PUT = "PUT";
    private static final String PATCH = "PATCH";
    private static final String CLIENT_IDENTIFIER =
            "java-client-" + Optional.ofNullable(UltraRestClient.class.getPackage().getImplementationVersion())
                    .orElse("unknown");
    private static final String ULTRA_CLIENT = "UltraClient";

    private final String baseUrl;
    private final AddAuth addAuth;
    private final UltraRestClientConfig ultraRestClientConfig;

    public UltraRestClient(String baseUrl, AddAuth addAuth) {
        this(baseUrl, addAuth, new UltraRestClientConfig(new UltraRestClientConfig.RetryOptions()));
    }

    public UltraRestClient(String baseUrl, AddAuth addAuth, UltraRestClientConfig ultraRestClientConfig) {
        this.baseUrl = baseUrl;
        this.addAuth = addAuth;
        this.ultraRestClientConfig = ultraRestClientConfig;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    private ClientResponse method(String method, Supplier<WebResource.Builder> webResourceBuilderSupplier) {
        return retryableMethod(method, webResourceBuilderSupplier, false, true);
    }

    private ClientResponse retryableMethod(String method, Supplier<WebResource.Builder> webResourceBuilderSupplier) {
        return retryableMethod(method, webResourceBuilderSupplier, true, true);
    }

    private ClientResponse method(String method, Supplier<WebResource.Builder> webResourceBuilderSupplier,
            boolean tryRefresh) {
        WebResource.Builder builder = webResourceBuilderSupplier.get();
        builder.header(ULTRA_CLIENT, CLIENT_IDENTIFIER);

        ClientResponse clientResponse = addAuth.addAuth(builder).method(method, ClientResponse.class);
        if (tryRefresh && (clientResponse.getClientResponseStatus().getStatusCode() == HttpStatus.SC_BAD_REQUEST
                || clientResponse.getClientResponseStatus().getStatusCode() == HttpStatus.SC_UNAUTHORIZED)) {
            Map<String, Object> errorResponse = getErrorResponse(clientResponse);

            Object error = errorResponse.get("error");
            if (error instanceof String && "invalid_grant".equals(error) && addAuth.refreshAuth(this)) {
                clientResponse = addAuth.addAuth(builder).method(method, ClientResponse.class);
            }
        }
        return clientResponse;
    }

    private ClientResponse retryableMethod(String method, Supplier<WebResource.Builder> webResourceBuilderSupplier,
            boolean retry, boolean tryRefresh) {
        ClientResponse clientResponse = null;
        int remainingRetryAttempts = ultraRestClientConfig.getRetryOptions().getMaxRetryAttempts();
        do {
            boolean exceptionRetry = false;
            try {
                clientResponse = method(method, webResourceBuilderSupplier, tryRefresh);
            } catch (Exception e) {
                exceptionRetry = isRetryableException(e);
                if (!exceptionRetry) {
                    throw e;
                }
            }

            if (!exceptionRetry && (!retry || (retry && Optional.ofNullable(clientResponse)
                    .map(ClientResponse::getClientResponseStatus)
                    .map(ClientResponse.Status::getStatusCode)
                    .map(statusCode -> !ultraRestClientConfig.getRetryOptions().getRetryOnStatusCodes()
                            .contains(statusCode))
                    .orElse(false)))) {
                return clientResponse;
            }

            if (remainingRetryAttempts > 0) {
                Optional.ofNullable(clientResponse).ifPresent(resp -> resp.close());
                sleepBeforeRetry(remainingRetryAttempts);
            }
            remainingRetryAttempts--;
        } while (remainingRetryAttempts >= 0);

        return clientResponse;
    }

    private boolean isRetryableException(Exception e) {
        for (Class<? extends Throwable> retryableClass : ultraRestClientConfig.getRetryOptions()
                .getMustRetryOnExceptions()) {
            if (retryableClass.isInstance(e) || (retryableClass.isInstance(e.getCause()))) {
                return true;
            }
        }
        return false;
    }

    private void sleepBeforeRetry(int remainingRetryAttempt) {
        // delay retry exponentially with a maximum wait time of some secs.
        long backoffSecs = (long) Math.pow(2,
                (ultraRestClientConfig.getRetryOptions().getMaxRetryAttempts() - remainingRetryAttempt));
        long sleepForSecs = Math.min(ultraRestClientConfig.getRetryOptions().getInitialIntervalSecs() + backoffSecs,
                ultraRestClientConfig.getRetryOptions().getMaxIntervalSecs());
        try {
            LOGGER.warn("Waiting for {} seconds before retry", sleepForSecs);
            TimeUnit.SECONDS.sleep(sleepForSecs);
        } catch (InterruptedException interruptedException) {
            // Nothing to do. Eat it.
        }
    }

    private Map<String, Object> getErrorResponse(ClientResponse clientResponse) {
        try {
            clientResponse.bufferEntity();
            //copy buffer to a string and put back a copy
            final ClientResponse finalClientResponse = clientResponse;

            ByteSource byteSource = new ByteSource() {
                @Override
                public InputStream openStream() throws IOException {
                    return finalClientResponse.getEntityInputStream();
                }
            };
            String buffer = byteSource.asCharSource(Charsets.UTF_8).read();

            clientResponse.setEntityInputStream(new ByteArrayInputStream(buffer.getBytes(Charsets.UTF_8)));

            return JsonUtils.jsonToGeneric(buffer);
        } catch (JsonMappingException e) {
            LOGGER.warn(e.getMessage());
            return Collections.emptyMap();
        } catch (Exception e) {
            //just eat the exception -- something else went wrong, it'll be found when the content is re-read
            //by higher-level code
            LOGGER.warn("Had a bad request that wasn't related to an auth issue.  ", e);
            return Collections.emptyMap();
        }
    }

    /**
     * To execute get operation.
     *
     * @param url - URL of the resource.
     * @return - Return JSON response in JSON string format.
     */
    public ClientData get(final String url) {
        LOGGER.debug("Executing GET request for " + baseUrl + url);
        return toClientData(retryableMethod(GET, () -> getBuilder(getWebResource(fixUrl(url)))));
    }

    /**
     * To execute get operation with query parameters.
     *
     * @param url - URL of the resource.
     * @return - Return JSON response in JSON string format.
     */
    public ClientData get(final String url, MultivaluedMap<String, String> queryParams) {
        LOGGER.debug("Executing GET request for " + baseUrl + url);
        return toClientData(
                retryableMethod(GET, () -> getBuilder(getWebResource(fixUrl(url)).queryParams(queryParams))));
    }

    /**
     * To execute post operation.
     *
     * @param url        - Resource URL
     * @param jsonString - Object in JSON string format.
     * @return - Return response in JSON string format.
     */
    public ClientData post(String url, String jsonString) {
        return post(url, null, jsonString);
    }

    /**
     * To execute post operation.
     *
     * @param url        - Resource URL
     * @param jsonString - Object in JSON string format.
     * @return - Return response in JSON string format.
     */
    public ClientData post(String url, MultivaluedMap<String, String> queryParams, String jsonString) {
        LOGGER.debug("Executing POST request for " + baseUrl + url);
        return toClientData(method(POST, () -> getBuilder(getWebResource(fixUrl(url)).queryParams(
                Optional.ofNullable(queryParams).orElse(new MultivaluedMapImpl()))).entity(jsonString)));
    }

    /**
     * To execute post operation.
     *
     * @param url - Resource URL
     * @return - Return response in JSON string format.
     */
    public ClientData post(final String url) {
        LOGGER.debug("Executing POST request for " + baseUrl + url);
        return toClientData(method(POST, () -> getBuilder(getWebResource(fixUrl(url)))));
    }

    /**
     * To execute post operation.
     *
     * @param url - Resource URL
     * @return - Return response in JSON string format.
     */
    public ClientData retryablePost(final String url) {
        return toClientData(retryableMethod(POST, () -> getBuilder(getWebResource(fixUrl(url)))));
    }

    /**
     * To execute post operation.
     *
     * @param url - Resource URL
     * @return - Return response in JSON string format.
     */
    public ClientData post(final String url, Form formData) {
        return post(url, formData, true);
    }

    public ClientData post(String url, Form formData, boolean tryRefresh) {
        LOGGER.debug("Executing POST request for " + baseUrl + url);
        return toClientData(retryableMethod(POST, () -> getBuilderForForm(getWebResource(fixUrl(url)), formData), false,
                tryRefresh));
    }

    /**
     * To execute post operation.
     *
     * @param url               - Resource URL
     * @param formDataBodyParts - The fields for the multi-part form.
     * @return - Return response in JSON string format.
     */
    public ClientData multipartPost(final String url, FormDataBodyPart... formDataBodyParts) {
        LOGGER.debug("Executing multipart POST request for " + baseUrl + url);

        WebResource webResource = getWebResource(fixUrl(url));
        return toClientData(method(POST, () -> getMultipartBuilder(webResource, formDataBodyParts)));
    }

    /**
     * To execute multipart PATCH operation.
     *
     * @param url               - Resource URL
     * @param formDataBodyParts - The fields for the form.
     * @return - Return response in JSON string format.
     */
    public ClientData multipartPatch(final String url, FormDataBodyPart... formDataBodyParts) {
        LOGGER.debug("Executing multipart PATCH request for " + baseUrl + url);
        WebResource webResource = getWebResource(fixUrl(url));
        return toClientData(retryableMethod(PATCH, () -> getMultipartBuilder(webResource, formDataBodyParts)));
    }

    /**
     * To execute multipart PATCH operation using a POST operation, with queryParameter _method set to PATCH.
     *
     * @param url               - Resource URL
     * @param formDataBodyParts - The fields for the form.
     * @return - Return response in JSON string format.
     */
    public ClientData multipartFakePatch(final String url, FormDataBodyPart... formDataBodyParts) {
        LOGGER.debug("Executing multipart fake PATCH request for " + baseUrl + url);
        WebResource webResource = getWebResource(fixUrl(url)).queryParam("_method", PATCH);
        return toClientData(method(POST, () -> getMultipartBuilder(webResource, formDataBodyParts)));
    }

    /**
     * To delete a resource on the server.
     *
     * @param url - URL
     * @return - {@link String}
     */
    public ClientData delete(final String url) {
        LOGGER.debug("Executing DELETE request for " + baseUrl + url);
        return toClientData(method(DELETE, () -> getBuilder(getWebResource(fixUrl(url)))));
    }

    /**
     * To update a resource on server.
     *
     * @param url - URL
     * @return - Return response in JSON string format.
     */
    public ClientData put(final String url, final String jsonString) {
        LOGGER.debug("Executing PUT request for " + baseUrl + url);
        return toClientData(retryableMethod(PUT, () -> getBuilder(getWebResource(fixUrl(url))).entity(jsonString)));
    }

    /**
     * To update a resource on server.
     *
     * @param url - URL
     * @return - Return response in JSON string format.
     */
    public ClientData patch(final String url, final String jsonString) {
        LOGGER.debug("Executing PATCH request for " + baseUrl + url);
        return toClientData(retryableMethod(PATCH, () -> getBuilder(getWebResource(fixUrl(url))).entity(jsonString)));
    }

    /**
     * To update a resource on server.  This uses POST to fake a patch with queryParam _method set to PATCH.
     *
     * @param url - URL
     * @return - Return response in JSON string format.
     */
    public ClientData fakePatch(final String url, final String jsonString) {
        LOGGER.debug("Executing PATCH request for " + baseUrl + url);
        WebResource webResource = getWebResource(fixUrl(url)).queryParam("_method", PATCH);
        return toClientData(method(POST, () -> getBuilder(webResource).entity(jsonString)));
    }

    /**
     * Convert Client Response into String format.
     *
     * @param clientResponse - {@link ClientResponse}
     * @return - String
     */
    private ClientData toClientData(final ClientResponse clientResponse) {
        if (clientResponse.getStatus() == Response.Status.NO_CONTENT.getStatusCode()) {
            return new ClientData(clientResponse.getHeaders(), null, clientResponse.getStatus());
        } else {
            return new ClientData(clientResponse.getHeaders(), clientResponse.getEntity(String.class),
                    clientResponse.getStatus());
        }
    }

    /**
     * This method create webresource for the given URL.
     *
     * @param url - URL in String
     * @return - {@link WebResource}
     */
    private WebResource getWebResource(final String url) {
        Client httpClient;
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put("com.sun.jersey.api.json.POJOMappingFeature", Boolean.TRUE);
        httpClient = ApacheHttpClient.create(clientConfig);

        return httpClient.resource(url);
    }

    private String fixUrl(String url) {

        String subUrl = url;
        if (baseUrl.endsWith("/") && url.startsWith("/")) {
            subUrl = url.substring(1);
        }
        if (!baseUrl.endsWith("/") && !url.startsWith("/")) {
            subUrl = "/" + url;
        }
        if (!subUrl.toLowerCase(Locale.US).startsWith(baseUrl.toLowerCase(Locale.US))) {
            return baseUrl + subUrl;
        } else {
            return subUrl;
        }
    }

    private WebResource.Builder getBuilder(WebResource webResource) {
        return webResource.accept(MediaType.APPLICATION_JSON_TYPE).type(MediaType.APPLICATION_JSON_TYPE);
    }

    private WebResource.Builder getBuilderForForm(WebResource webResource, Form formData) {
        return webResource.accept(MediaType.APPLICATION_JSON_TYPE)
                .type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
                .entity(formData);
    }

    private WebResource.Builder getMultipartBuilder(WebResource webResource, FormDataBodyPart... formDataBodyParts) {
        FormDataMultiPart formDataMultiPart = new FormDataMultiPart();

        for (FormDataBodyPart formDataBodyPart : formDataBodyParts) {
            formDataMultiPart.bodyPart(formDataBodyPart);
        }

        return webResource.accept(MediaType.APPLICATION_JSON_TYPE)
                .type(MediaType.MULTIPART_FORM_DATA_TYPE)
                .entity(formDataMultiPart);
    }

}
