package org.controledeestoque.utils;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathFXML {
    public static URL getPath(String nomeArquivo){
        return PathFXML.class.getResource("org/controledeestoque/view/" + nomeArquivo);
    }
}
