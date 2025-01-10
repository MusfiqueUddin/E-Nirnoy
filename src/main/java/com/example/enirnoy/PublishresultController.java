package com.example.enirnoy;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

public class PublishresultController {
        @FXML
        private ComboBox<String> electionComboBox;
        @FXML
        private ComboBox<String> divisionComboBox;
        @FXML
        private ComboBox<String> districtComboBox;
        @FXML
        private ListView<String> winnerListView;

        private ObservableList<String> electionTypes = FXCollections.observableArrayList("City Corporation", "Upazila", "Parliament", "Municipality");
        private ObservableList<String> divisions = FXCollections.observableArrayList("Division 1", "Division 2", "Division 3");
        private ObservableList<String> districts = FXCollections.observableArrayList("District 1", "District 2", "District 3");
        private ObservableList<String> wards = FXCollections.observableArrayList("Ward 1", "Ward 2", "Ward 3");
        private ObservableList<String> upazilas = FXCollections.observableArrayList("Upazila 1", "Upazila 2", "Upazila 3");

        @FXML
        public void initialize() {
            electionComboBox.setItems(electionTypes);
            divisionComboBox.setItems(divisions);

            electionComboBox.setOnAction(event -> updateDistrictOptions());
        }

        private void updateDistrictOptions() {
            String selectedElection = electionComboBox.getValue();

            if (selectedElection == null) return;

            switch (selectedElection) {
                case "City Corporation":
                    districtComboBox.setItems(wards);
                    break;
                case "Upazila":
                    districtComboBox.setItems(upazilas);
                    break;
                case "Parliament":
                case "Municipality":
                    districtComboBox.setItems(districts);
                    break;
            }

            // Show winners based on the selection
            showWinners(selectedElection);
        }

        private void showWinners(String election) {
            ObservableList<String> winners = FXCollections.observableArrayList();

            // Simulate showing winners based on election type
            switch (election) {
                case "City Corporation":
                    winners.add("Winner 1 (Ward 1)");
                    winners.add("Winner 2 (Ward 2)");
                    break;
                case "Upazila":
                    winners.add("Winner 1 (Upazila 1)");
                    break;
                case "Parliament":
                    winners.add("Winner 1 (District 1)");
                    break;
                case "Municipality":
                    winners.add("Winner 1 (District 1)");
                    break;
            }

            winnerListView.setItems(winners);
        }
    }

