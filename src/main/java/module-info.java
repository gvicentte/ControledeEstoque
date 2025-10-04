module org.controledeestoque {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;
    requires javafx.base;


    //opens org.controledeestoque to javafx.fxml;
    opens org.controledeestoque.controller to javafx.fxml;
    exports org.controledeestoque.controller;
    //exports org.controledeestoque.view;
    exports org.controledeestoque.utils;
    exports org.controledeestoque.model;
    exports org.controledeestoque.principal;
    opens org.controledeestoque.principal to javafx.fxml;
}