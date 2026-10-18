package com.mycompany.ejercicio3_1_conteo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class PrimaryController implements Initializable {

    @FXML private TextField txtContador;
    @FXML private ProgressBar barraProgreso;
    @FXML private Button btnEsperar;
    
    private int clics = 0;

    @FXML
    private void contarClic(ActionEvent event) {
        clics++;
        txtContador.setText(String.valueOf(clics));
    }

    @FXML
    private void iniciarEspera(ActionEvent event) {
        btnEsperar.setDisable(true);
        barraProgreso.setProgress(0.0);
        Thread hilo = new Thread(() -> {
            try {
                for (int i = 1; i <= 100; i++) {
                    Thread.sleep(100); 
                    final double progreso = i / 100.0;
                    Platform.runLater(() -> {
                        barraProgreso.setProgress(progreso);
                    });
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                Platform.runLater(() -> {
                    btnEsperar.setDisable(false);
                });
            }
        });
        
        hilo.start(); 
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtContador.setText("0");
    }
}