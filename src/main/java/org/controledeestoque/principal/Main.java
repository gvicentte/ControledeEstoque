package org.controledeestoque.principal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import org.controledeestoque.utils.PathFXML;

import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.nio.file.Paths;

import static org.controledeestoque.utils.PathFXML.pathFXML;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(new FileInputStream(PathFXML.getPath() + "\\ControledeEstoque.fxml"));
        Scene scene = new Scene(root, 700, 500);
        stage.setTitle("Controle de Estoque!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}