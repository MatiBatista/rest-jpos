package org.jpos.rest.config.inyection;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;


@Provider
public class ObjectMapperProvider implements ContextResolver<ObjectMapper> {

    private final ObjectMapper objectMapper;

    public ObjectMapperProvider() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule()); // Registrar el módulo para compatibilidad con java.time
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return objectMapper;
    }
}

/*
class TimeConfiguration {
    public static ObjectMapper createObjectMapper(){
        ObjectMapper mapper = new ObjectMapper();
        // Registra el módulo de JavaTime
        mapper.registerModule(new JavaTimeModule());
        return mapper;
    }
}*/
