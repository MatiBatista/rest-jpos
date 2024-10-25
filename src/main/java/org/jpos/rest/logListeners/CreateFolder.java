package org.jpos.rest.logListeners;



import org.jpos.rest.utils.Utils;

import java.io.File;

public class CreateFolder {

    private static String fs = System.getProperty("file.separator");

    String Folder = new File("").getAbsolutePath();

    File newFolder = new File(Folder + fs + "jposlog" + fs + Utils.getHostname());


    protected final void createFolder() {
        try {
            if (!newFolder.exists()) {
                if (newFolder.mkdirs()) {
                    System.out.println("Folder creado");
                } else {
                    System.out.println("Error al crear el Folder");
                }
            }
        } catch (Exception ex) {
            System.out.println(Utils.printException(ex));
        }
    }
}

