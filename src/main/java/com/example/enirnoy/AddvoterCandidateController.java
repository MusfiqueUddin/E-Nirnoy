package com.example.enirnoy;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class AddvoterCandidateController {
       @FXML private ComboBox<String> electionComboBox;
        @FXML private ComboBox<String> typeComboBox;
        @FXML private TextField nameTextField;
        @FXML private TextField nidTextField;
        @FXML private Button addButton;
        @FXML private Button removeButton;

        // ObservableList to store the main list of voters/candidates
        private final ObservableList<VoterCandidate> mainList = FXCollections.observableArrayList();

        @FXML
        public void initialize() {
            // Initialize the ComboBoxes
            electionComboBox.setItems(FXCollections.observableArrayList("City Corporation", "Upazila Parishod", "Municipality", "National Parliament"));
            typeComboBox.setItems(FXCollections.observableArrayList("Voter", "Candidate"));

            // Set placeholders or default values
            electionComboBox.setPromptText("Select Election");
            typeComboBox.setPromptText("Select Type");
        }

        @FXML
        private void handleAddButton(ActionEvent event) {
            // Get values from the input fields
            String election = electionComboBox.getSelectionModel().getSelectedItem();
            String type = typeComboBox.getSelectionModel().getSelectedItem();
            String name = nameTextField.getText().trim();
            String nid = nidTextField.getText().trim();

            // Validate inputs
            if (election == null || type == null || name.isEmpty() || nid.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Invalid Input", "All fields must be filled out.");
                return;
            }

            // Add the new voter/candidate to the main list
            VoterCandidate newEntry = new VoterCandidate(election, type, name, nid);
            mainList.add(newEntry);

            // Clear the input fields
            clearFields();

            // Show success message
            showAlert(Alert.AlertType.INFORMATION, "Success", "Details added successfully!");
        }

        @FXML
        private void handleRemoveButton(ActionEvent event) {
            String nid = nidTextField.getText().trim();

            // Validate NID
            if (nid.isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Invalid Input", "Please enter the NID to remove.");
                return;
            }

            // Find and remove the entry with the given NID
            VoterCandidate toRemove = null;
            for (VoterCandidate entry : mainList) {
                if (entry.getNid().equals(nid)) {
                    toRemove = entry;
                    break;
                }
            }

            if (toRemove != null) {
                mainList.remove(toRemove);
                clearFields();
                showAlert(Alert.AlertType.INFORMATION, "Success", "Details removed successfully!");
            } else {
                showAlert(Alert.AlertType.WARNING, "Not Found", "No entry found with the given NID.");
            }
        }

        // Method to clear input fields
        private void clearFields() {
            electionComboBox.getSelectionModel().clearSelection();
            typeComboBox.getSelectionModel().clearSelection();
            nameTextField.clear();
            nidTextField.clear();
        }

        // Utility method to show alerts
        private void showAlert(Alert.AlertType alertType, String title, String message) {
            Alert alert = new Alert(alertType);
            alert.setTitle(title);
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.showAndWait();
        }

        // Getter for mainList (optional, for other parts of the program to access the data)
        public ObservableList<VoterCandidate> getMainList() {
            return mainList;
        }
    }
