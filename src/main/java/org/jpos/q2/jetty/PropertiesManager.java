package org.jpos.q2.jetty;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.Properties;

public class PropertiesManager{

    public static Properties buildProperties(String propertieFile) throws FileNotFoundException, IOException{
        InputStream input = PropertiesManager.class.getClassLoader().getResourceAsStream(propertieFile);
        Properties output = new Properties();
        output.load(input);
        return output;
    }


}
