package com.example.enirnoy;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

public class MunicipalityresultController {
        @FXML
        private ComboBox<String> divisionComboBox;
        @FXML
        private ComboBox<String> districtComboBox;
        @FXML
        private ComboBox<String> pourosovaComboBox;
        @FXML
        private ListView<Candidate> candidateListView;

        @FXML
        private Button mayorButton;
        @FXML
        private Button councilorButton;
        @FXML
        private Button womanCouncilorButton;

        private ObservableList<String> divisions = FXCollections.observableArrayList("Division 1", "Division 2", "Division 3");
        private ObservableList<String> districts = FXCollections.observableArrayList("District 1", "District 2", "District 3");
        private ObservableList<String> pourosovas = FXCollections.observableArrayList("Pourosova 1", "Pourosova 2", "Pourosova 3");

        @FXML
        public void initialize() {
            // Initialize ComboBoxes
            divisionComboBox.setItems(divisions);
            districtComboBox.setItems(districts);
            pourosovaComboBox.setItems(pourosovas);

            // Set up the ListView to use a custom cell factory to display Candidate's name and votes
            candidateListView.setCellFactory(param -> new CandidateCell());
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

            // Call method to display the candidates with their votes
            displayCandidates(selectedDivision, selectedDistrict, selectedPourosova, selectedPosition);
        }

        private void displayCandidates(String division, String district, String pourosova, String position) {
            ObservableList<Candidate> candidates = FXCollections.observableArrayList();

            // Simulate candidates and their votes based on the position
            if (position.equals("Mayor")) {
                candidates.add(new Candidate("Mayor Candidate 1", 5000));
                candidates.add(new Candidate("Mayor Candidate 2", 3000));
            } else if (position.equals("Councilor")) {
                candidates.add(new Candidate("Councilor Candidate 1", 2000));
                candidates.add(new Candidate("Councilor Candidate 2", 2500));
            } else if (position.equals("Woman Councilor")) {
                candidates.add(new Candidate("Woman Councilor Candidate 1", 1500));
                candidates.add(new Candidate("Woman Councilor Candidate 2", 1800));
            }

            // Display candidates in the ListView
            candidateListView.setItems(candidates);
        }

        // Candidate class with a name and vote count
        public static class Candidate {
            private String name;
            private int votes;

            public Candidate(String name, int votes) {
                this.name = name;
                this.votes = votes;
            }

            public String getName() {
                return name;
            }

            public int getVotes() {
                return votes;
            }
        }

        // Custom cell factory for ListView to display Candidate name and votes
        public static class CandidateCell extends javafx.scene.control.ListCell<Candidate> {
            @Override
            protected void updateItem(Candidate candidate, boolean empty) {
                super.updateItem(candidate, empty);
                if (empty || candidate == null) {
                    setText(null);
                } else {
                    setText(candidate.getName() + " - Votes: " + candidate.getVotes());
                }
            }
        }
    }

