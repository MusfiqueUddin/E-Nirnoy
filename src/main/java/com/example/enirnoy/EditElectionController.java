package com.example.enirnoy;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class EditElectionController {
        @FXML
        private Button addCandidateButton;
        @FXML
        private Button addVoterButton;
        @FXML
        private Button removeCandidateButton;
        @FXML
        private Button removeVoterButton;

        // Method to open the AddVoterCandidate scene for all buttons
        @FXML
        private void openAddVoterCandidateScene() {
            try {
                // Load the AddVoterCandidate.fxml
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AddVoterCandidate.fxml"));
                Stage stage = new Stage();
                stage.setScene(new Scene(loader.load()));
                stage.setTitle("Add/Remove Candidate or Voter");
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
