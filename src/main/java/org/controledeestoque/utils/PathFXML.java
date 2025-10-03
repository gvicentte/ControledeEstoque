package org.controledeestoque.utils;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathFXML {
    public static String pathFXML(){
        String path = "src/main/java/org/controledeestoque/view";
        return Paths.get(path).toAbsolutePath().toString();
    }
}
