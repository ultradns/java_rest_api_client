package biz.neustar.ultra.rest.util;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

/*
 * User: jbodner
 * Date: 7/9/13
 * Time: 1:29 PM
 *
 * Copyright 2000-2013 NeuStar, Inc. All rights reserved.
 * NeuStar, the Neustar logo and related names and logos are registered
 * trademarks, service marks or tradenames of NeuStar, Inc. All other
 * product names, company names, marks, logos and symbols may be trademarks
 * of their respective owners.
 */
public final class JsonUtils {

    /**
     * Json object mapper.
     */
    private static final ObjectMapper MAPPER = new ObjectMapper();

    private JsonUtils() {
        //does nothing, makes class a singleton
    }

    /**
     * This method will convert JSON string into object based on given type.
     *
     * @param content   - JSON String.
     * @param valueType - Type of JSON String in java
     * @return - Return object of given type.
     * @throws java.io.IOException - {@link java.io.IOException}
     */
    public static <T> T jsonToObject(final String content,
                                    final Class<T> valueType) throws IOException {
        return MAPPER.readValue(content, valueType);
    }

    /**
     * This method will convert JSON Content Stream into object based on given type.
     *
     * @param contentStream   - InputStream with JSON content.
     * @param valueType - Type of JSON String in java
     * @return - Return object of given type.
     * @throws java.io.IOException - {@link java.io.IOException}
     */
    public static <T> T jsonToObject(final InputStream contentStream,
                                     final Class<T> valueType) throws IOException {
        return MAPPER.readValue(contentStream, valueType);
    }

    /**
     * This will convert given java object into JSON String.
     *
     * @param object - JAVA object.
     * @return - JSON String.
     * @throws IOException - {@link IOException}
     */
    public static String objectToJson(Object object)
            throws IOException {
        return MAPPER.writeValueAsString(object);
    }

}
