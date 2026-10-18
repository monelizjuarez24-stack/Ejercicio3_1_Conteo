module com.mycompany.ejercicio3_1_conteo {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.ejercicio3_1_conteo to javafx.fxml;
    exports com.mycompany.ejercicio3_1_conteo;
}
