package com.example.enirnoy;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ListofElectionController {
        @FXML
        private Button parliamentButton;

        @FXML
        private Button cityCorporationButton;

        @FXML
        private Button upazilaButton;

        @FXML
        private Button municipalityButton;

        @FXML
        private Button editElectionButton;

        @FXML
        public void initialize() {
            // Action for National Parliament Election button
            parliamentButton.setOnAction(e -> loadScene("ParliamentElection.fxml"));

            // Action for City Corporation Election button
            cityCorporationButton.setOnAction(e -> loadScene("CitycorporationElection.fxml"));

            // Action for Upazila Parishad Election button
            upazilaButton.setOnAction(e -> loadScene("Upazilaelection.fxml"));

            // Action for Municipality Election button
            municipalityButton.setOnAction(e -> loadScene("Municipalityelec.fxml"));

            // Action for Edit Election button
            editElectionButton.setOnAction(e -> loadScene("Editelection.fxml"));
        }

        // Method to load a specific scene
        private void loadScene(String fxmlFileName) {
            try {
                Stage stage = (Stage) parliamentButton.getScene().getWindow(); // Get the current window
                FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
                Scene scene = new Scene(loader.load(), 600, 400); // Set the preferred scene dimensions
                stage.setScene(scene);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
