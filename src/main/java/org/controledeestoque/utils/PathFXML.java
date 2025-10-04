package org.controledeestoque.utils;

import java.net.URL;

public class PathFXML {
    public static URL getPath(String nomeArquivo){
        return PathFXML.class.getResource("/org/view/" + nomeArquivo);
    }
}
