package org.jpos.q2.jetty;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesManager {

    public static Properties buildProperties(String propertieFile) throws FileNotFoundException, IOException{
        InputStream input = PropertiesManager.class.getClassLoader().getResourceAsStream(propertieFile);
        Properties output = new Properties();
        output.load(input);
        return output;
    }
}
