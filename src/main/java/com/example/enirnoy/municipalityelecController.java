package com.example.enirnoy;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

public class municipalityelecController {
        @FXML
        private ComboBox<String> divisionComboBox;
        @FXML
        private ComboBox<String> districtComboBox;
        @FXML
        private ComboBox<String> pourosovaComboBox;
        @FXML
        private ListView<String> candidateListView;

        @FXML
        private Button mayorButton;
        @FXML
        private Button councilorButton;
        @FXML
        private Button womanCouncilorButton;

        private ObservableList<String> divisions = FXCollections.observableArrayList("Dhaka", "Division 2", "Division 3");
        private ObservableList<String> districts = FXCollections.observableArrayList("District 1", "District 2", "District 3");
        private ObservableList<String> pourosovas = FXCollections.observableArrayList("Pourosova 1", "Pourosova 2", "Pourosova 3");

        @FXML
        public void initialize() {
            // Initialize ComboBoxes
            divisionComboBox.setItems(divisions);
            districtComboBox.setItems(districts);
            pourosovaComboBox.setItems(pourosovas);
        }

        @FXML
        private void showCandidates() {
            String selectedDivision = divisionComboBox.getValue();
            String selectedDistrict = districtComboBox.getValue();
            String selectedPourosova = pourosovaComboBox.getValue();

            // Get the text from the clicked button (Mayor, Councilor, Woman Councilor)
            String selectedPosition = "";
            if (mayorButton.isPressed()) {
                selectedPosition = "Mayor";
            } else if (councilorButton.isPressed()) {
                selectedPosition = "Councilor";
            } else if (womanCouncilorButton.isPressed()) {
                selectedPosition = "Woman Councilor";
            }

            // Call method to display the candidates based on the selected positions
            displayCandidates(selectedDivision, selectedDistrict, selectedPourosova, selectedPosition);
        }

        private void displayCandidates(String division, String district, String pourosova, String position) {
            ObservableList<String> candidates = FXCollections.observableArrayList();

            // Simulate candidates based on position
            if (position.equals("Mayor")) {
                candidates.add("Mayor Candidate 1");
                candidates.add("Mayor Candidate 2");
            } else if (position.equals("Councilor")) {
                candidates.add("Councilor Candidate 1");
                candidates.add("Councilor Candidate 2");
            } else if (position.equals("Woman Councilor")) {
                candidates.add("Woman Councilor Candidate 1");
                candidates.add("Woman Councilor Candidate 2");
            }

            // Display candidates in the ListView
            candidateListView.setItems(candidates);
        }
    }


