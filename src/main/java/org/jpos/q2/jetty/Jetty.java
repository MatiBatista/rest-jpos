/*
 * jPOS Project [http://jpos.org]
 * Copyright (C) 2000-2021 jPOS Software SRL
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.jpos.q2.jetty;

import io.swagger.v3.jaxrs2.integration.OpenApiServlet;
import org.eclipse.jetty.ee10.servlet.DefaultServlet;
import org.eclipse.jetty.ee10.servlet.ServletContextHandler;
import org.eclipse.jetty.ee10.servlet.ServletHolder;
import org.eclipse.jetty.server.*;

import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.server.handler.ResourceHandler;

import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.jpos.core.Configuration;
import org.jpos.core.ConfigurationException;
import org.jpos.q2.QBeanSupport;
import org.jpos.rest.App;
import org.jpos.rest.controllers.Echo;
import org.jpos.security.SensitiveString;

import java.util.Arrays;
import java.util.Properties;
import java.util.ServiceLoader;
import java.util.stream.IntStream;


/**
 * <a href="https://www.eclipse.org/jetty/javadoc/jetty-9/deprecated-list.html">Jetty 9 deprecated list</a>
 * <a href="https://www.eclipse.org/jetty/javadoc/jetty-10/deprecated-list.html">Jetty 10 deprecated list</a>
 */
public class Jetty extends QBeanSupport implements JettyMBean {
    private String config;
    private Server server;
    private SensitiveString keystorePassword;


    @Override
    public void initService() throws Exception {

        //INSTANCIAMOS PROPERTIES
        Properties prop = PropertiesManager.buildProperties("application.properties");

        //CREAMOS INSTANCIA DE SERVIDOR
        server = new Server();

        //CONFIGURACION HTTP Y Y FABRICA DE CONEXIONES
        HttpConfiguration httpConfig = new HttpConfiguration();
        HttpConnectionFactory http11 = new HttpConnectionFactory(httpConfig);

        //CREAMOS UN SERVER CONNECTOR PARA CONEXIONES DE CLIENTES
        ServerConnector connector = new ServerConnector(server, http11);
        connector.setPort(Integer.parseInt(prop.getProperty("server.port")));
        connector.setAcceptQueueSize(Integer.parseInt(prop.getProperty("server.setAcceptQueueSize")));
        server.addConnector(connector);


        // Crear contexto ContextHandlerCollection
        ContextHandlerCollection contextos = new ContextHandlerCollection();
        server.setHandler(contextos);


        // configuracion de los handlers
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        ServletHolder servletHolder = context.addServlet(ServletContainer.class, prop.getProperty("jetty.servletholder.path"));
        servletHolder.setInitOrder(Integer.parseInt(prop.getProperty("jetty.servletholder.initOrder")));

        IntStream.range(0,prop.size()/2)
                .mapToObj(i->{
                    String param = prop.getProperty("jetty.servletholder.initParameters[" + i + "].param");
                    String value = prop.getProperty("jetty.servletholder.initParameters[" + i + "].value");
                    return new String[]{param,value};
                }).filter(arr-> arr[0] != null && arr[1] != null)
                .forEach(arr -> servletHolder.setInitParameter(arr[0],arr[1]));

       /* servletHolder.setInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, App.class.getName());
        servletHolder.setInitParameter("jersey.config.server.provider.packages","io.swagger.v3.jaxrs2.integration.resources");
        */

        // Configurar recursos estáticos de Swagger-UI
        String resourceBasePath = Jetty.class.getResource(prop.getProperty("swagger-ui.directory")).toExternalForm();
        context.setWelcomeFiles(new String[] {"index.html"});
        context.setBaseResourceAsString(resourceBasePath);
        context.addServlet(new ServletHolder(new DefaultServlet()), "/*");


    }

    @Override
    public void setConfiguration(Configuration cfg) throws ConfigurationException {
        super.setConfiguration(cfg);
        try {
            keystorePassword = new SensitiveString(cfg.get("keystorePassword"));
        }
        catch (Exception e) {
            throw new ConfigurationException(e);
        }
    }

    @Override
    public void startService() throws Exception {
        server.start();
    }

    @Override
    public void stopService() throws Exception {
        server.stop();
    }

    @Override
    public void setConfig(String config) {
        this.config = config;
    }

    @Override
    public String getConfig() {
        return config;
    }
}
