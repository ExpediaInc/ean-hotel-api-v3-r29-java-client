package com.ean.client.v3.service;

import java.text.SimpleDateFormat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

/**
 * Implementation of the ObjectMapperFactory.
 */
@Provider
public class ObjectMapperProvider implements ContextResolver<ObjectMapper> {

    public static final String DATE_FORMAT = "MM/dd/yyyy";
    private static final ObjectMapper OBJECT_MAPPER = createObjectMapper();

    /**
     * Generates a context object mapper with configured properties as needed.
     * @param type This parameter is completely ignored, as it's not relevant, but is required by the interface.
     * @return configured object mapper.
     */
    @Override
    public ObjectMapper getContext(final Class<?> type) {
        return OBJECT_MAPPER;
    }

    private static ObjectMapper createObjectMapper() {
        final ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        om.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        om.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        om.setDateFormat(new SimpleDateFormat(DATE_FORMAT));
        return om;
    }
}
