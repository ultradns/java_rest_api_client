package biz.neustar.ultra.rest.client.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;

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
 *
 * Yes, this is a duplicate of the same class in the service.  If we end up with a collection
 * of classes like this, we'll make a shared library.  For now, we can just duplicate this little class.
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
    public static <T> T jsonToObject(final String content, final Class<T> valueType) throws IOException {
        return MAPPER.readValue(content, valueType);
    }

    /**
     * This method will convert JSON Content Stream into object based on given type.
     *
     * @param contentStream - InputStream with JSON content.
     * @param valueType     - Type of JSON String in java
     * @return - Return object of given type.
     * @throws java.io.IOException - {@link java.io.IOException}
     */
    public static <T> T jsonToObject(final InputStream contentStream, final Class<T> valueType) throws IOException {
        return MAPPER.readValue(contentStream, valueType);
    }

    /**
     * This will convert given java object into JSON String.
     *
     * @param object - JAVA object.
     * @return - JSON String.
     * @throws java.io.IOException - {@link java.io.IOException}
     */
    public static String objectToJson(Object object) throws IOException {
        return MAPPER.writeValueAsString(object);
    }

    public static Map<String, Object> jsonToGeneric(String json) throws IOException {
        return MAPPER.readValue(json, Map.class);
    }

    public static Map<String, Object> jsonToGeneric(InputStream contentStream) throws IOException {
        return MAPPER.readValue(contentStream, Map.class);
    }

    public static <T> List<T> jsonToList(InputStream contentStream, Class<T> clazz) throws IOException {
        TypeReference typeReference = new CollectionTypeReference<>(List.class, clazz);
        return MAPPER.readValue(contentStream, typeReference);
    }

    public static <T> Map<String, T> jsonToMap(InputStream contentStream, Class<T> clazz) throws IOException {
        TypeReference typeReference = new CollectionTypeReference<>(Map.class, String.class, clazz);
        return MAPPER.readValue(contentStream, typeReference);
    }

    public static <T> List<T> jsonToList(String json, Class<T> clazz) throws IOException {
        TypeReference typeReference = new CollectionTypeReference<>(List.class, clazz);
        return MAPPER.readValue(json, typeReference);
    }

    public static <T> Map<String, T> jsonToMap(String json, Class<T> clazz) throws IOException {
        TypeReference typeReference = new CollectionTypeReference<>(Map.class, String.class, clazz);
        return MAPPER.readValue(json, typeReference);
    }

    private static final class CollectionTypeReference<T> extends TypeReference<Collection<T>> {
        private final Class collectionClazz;
        private final Class[] valueClazz;

        CollectionTypeReference(Class collectionClazz, Class... valueClazz) {
            super();
            this.collectionClazz = collectionClazz;
            this.valueClazz = valueClazz;
        }

        @Override
        public Type getType() {
            return new ParameterizedType() {
                @Override
                public Type[] getActualTypeArguments() {
                    return valueClazz;
                }

                @Override
                public Type getRawType() {
                    return collectionClazz;
                }

                @Override
                public Type getOwnerType() {
                    return null;
                }
            };
        }
    }
}
