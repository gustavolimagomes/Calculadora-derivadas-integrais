module com.example.projeto {
    requires javafx.controls;
    requires javafx.fxml;
    requires matheclipse.core;
    requires com.fasterxml.jackson.databind;
    requires javafx.graphics;


    opens com.example.projeto to javafx.fxml;
    exports com.example.projeto;
}