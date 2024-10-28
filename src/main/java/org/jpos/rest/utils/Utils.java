package org.jpos.rest.utils;

import java.io.PrintWriter;
import java.io.StringWriter;



public class Utils implements Constants {

    public static String getHostname() {
        String hostname = System.getenv(ENVIRONMENT_VAR_HOSTNAME);
        if (hostname != null && !hostname.trim().isEmpty()) {
            return hostname;
        } else {
            return System.getenv(ENVIRONMENT_VAR_COMPUTERNAME);
        }
    }

    public static String getNode() {
        String node = System.getenv(ENVIRONMENT_VAR_NODE_NAME);
        if (node != null && !node.trim().isEmpty()) {
            if (node.length() <= 8) {
                return node;
            }
            return node.substring(0, 8);
        }
        return "NOTSETED";
    }

    public static String printException(Exception ex) {
        StringWriter sw = new StringWriter();
        ex.printStackTrace(new PrintWriter(sw));
        return sw.toString();
    }
}
