package org.jpos.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.integration.SwaggerConfiguration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.jpos.rest.Exceptions.ExceptionProvider;

import org.jpos.rest.config.inyection.MyApplicationBinder;


import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Path;
import javax.ws.rs.ext.ContextResolver;



@Path("/")
@OpenAPIDefinition(
        info = @io.swagger.v3.oas.annotations.info.Info(
                title = "CABAL | Integración con Thales TGI",
                version = "1.0.0"
        ),
        servers = {
                @io.swagger.v3.oas.annotations.servers.Server(url = "/issuer/igwapi/v2.0")
        }
)
public class App extends ResourceConfig {

    public App() {
        super();
        register(JacksonFeature.class);
        register(new App.Resolver());
        register(new MyApplicationBinder());
        packages("org.jpos.rest");
        register(ExceptionProvider.class);
        register(OpenApiResource.class);
    }


    static class Resolver implements ContextResolver<ObjectMapper> {
        final ObjectMapper defaultObjectMapper = createDefaultMapper();
        @Override
        public ObjectMapper getContext(Class<?> type) {
            return defaultObjectMapper;
        }
        private ObjectMapper createDefaultMapper() {
            final ObjectMapper mapper = new ObjectMapper();
            mapper.configure(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN, true);
            mapper.configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, true);
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            return mapper;
        }
    }
}

