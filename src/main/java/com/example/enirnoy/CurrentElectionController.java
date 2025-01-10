package com.example.enirnoy;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CurrentElectionController {
        @FXML
        private ComboBox<String> electionComboBox; // ComboBox for selecting election
        @FXML
        private Button saveButton; // Button to save the election
        @FXML
        private Button startButton; // Button to start the election
        @FXML
        private Button endButton; // Button to end the election
        @FXML
        private Button pauseButton; // Button to pause the election
        @FXML
        private Button editButton; // Button to edit the election

        private boolean electionRunning = false; // Flag to check if the election is running
        private boolean electionPaused = false; // Flag to check if the election is paused

        // Method to handle Save Election
        @FXML
        private void handleSaveElection() {
            // Implement save logic, for now just print selected election
            String selectedElection = electionComboBox.getSelectionModel().getSelectedItem();
            System.out.println("Saved election: " + selectedElection);
            // You can add logic here to save the election to a database or a file
        }

        // Method to handle Start Election
        @FXML
        private void handleStartElection() {
            if (electionComboBox.getSelectionModel().getSelectedItem() != null) {
                // Start the election if it's not already running
                if (!electionRunning) {
                    electionRunning = true;
                    electionPaused = false;
                    System.out.println("Election started: " + electionComboBox.getSelectionModel().getSelectedItem());
                    // Disable the Start button and enable Pause and End buttons
                    startButton.setDisable(true);
                    pauseButton.setDisable(false);
                    endButton.setDisable(false);
                }
            } else {
                System.out.println("Please select an election before starting.");
            }
        }

        // Method to handle End Election
        @FXML
        private void handleEndElection() {
            if (electionRunning) {
                electionRunning = false;
                electionPaused = false;
                System.out.println("Election ended.");
                // Disable Pause and End buttons, enable Start button
                startButton.setDisable(false);
                pauseButton.setDisable(true);
                endButton.setDisable(true);
            }
        }

        // Method to handle Pause Election
        @FXML
        private void handlePauseElection() {
            if (electionRunning && !electionPaused) {
                electionPaused = true;
                System.out.println("Election paused.");
                // Disable Pause button, enable Resume button (if needed)
                pauseButton.setText("Resume");
            } else if (electionRunning && electionPaused) {
                electionPaused = false;
                System.out.println("Election resumed.");
                // Disable Resume button, enable Pause button
                pauseButton.setText("Pause");
            }
        }

        // Method to handle Edit Election
        @FXML
        private void handleEditElection(MouseEvent event) {
            try {
                // Go back to the election ComboBox to select a new election
                Stage stage = (Stage) editButton.getScene().getWindow(); // Get current window (stage)
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ListofElection.fxml")); // Load List of Election scene
                Scene scene = new Scene(loader.load(), 800, 600); // Set new scene size (adjust as necessary)
                stage.setScene(scene); // Set the scene on the stage
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        // Initialize method to set up ComboBox options (for example, list of elections)
        @FXML
        public void initialize() {
            // Adding sample election options to the ComboBox
            electionComboBox.getItems().addAll("Election 1", "Election 2", "Election 3"); // Sample elections
            startButton.setDisable(true); // Disable start button initially
            pauseButton.setDisable(true); // Disable pause button initially
            endButton.setDisable(true); // Disable end button initially
        }
    }

