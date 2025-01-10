package com.example.enirnoy;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleButton;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CitycorporationreultController {
        @FXML
        private ComboBox<String> cityComboBox;

        @FXML
        private ComboBox<String> wardComboBox;

        @FXML
        private ToggleButton mayorToggleButton;

        @FXML
        private ToggleButton councilorToggleButton;

        @FXML
        private ToggleButton womanCouncilorToggleButton;

        @FXML
        private ListView<String> candidateListView;

        // City and Ward Data
        private final Map<String, List<String>> cityWardMap = new HashMap<>() {{
            put("Dhaka North", List.of("Ward 1", "Ward 2", "Ward 3", "Ward 4"));
            put("Dhaka South", List.of("Ward 5", "Ward 6", "Ward 7", "Ward 8"));
            put("Chittagong", List.of("Ward 9", "Ward 10", "Ward 11", "Ward 12"));
        }};

        // Candidate Data
        private final Map<String, List<String>> mayorCandidates = new HashMap<>() {{
            put("Dhaka North", List.of(
                    "Md. Asaduzzaman - 10,000 votes",
                    "Md. Karim Khan - 8,000 votes",
                    "Md. Rahim Ullah - 6,500 votes"
            ));
            put("Dhaka South", List.of(
                    "Md. Sajid Khan - 9,500 votes",
                    "Md. Nasir Uddin - 7,800 votes",
                    "Md. Abdullah - 7,200 votes"
            ));
            put("Chittagong", List.of(
                    "Md. Khaled Mahmud - 12,000 votes",
                    "Md. Rashid Ahmed - 10,500 votes",
                    "Md. Akhtar Hossain - 9,000 votes"
            ));
        }};

        private final Map<String, List<String>> councilorCandidates = new HashMap<>() {{
            put("Ward 1", List.of(
                    "Md. Jamil Hossain - 5,000 votes",
                    "Md. Kamal Khan - 4,800 votes",
                    "Md. Hasib Rahman - 4,200 votes"
            ));
            put("Ward 2", List.of(
                    "Md. Wahid Khan - 6,500 votes",
                    "Md. Bashir Ullah - 6,000 votes",
                    "Md. Anisur Rahman - 5,800 votes"
            ));
            put("Ward 3", List.of(
                    "Md. Rafiq Ullah - 7,000 votes",
                    "Md. Khaled Ahmed - 6,400 votes",
                    "Md. Ahsan Habib - 6,200 votes"
            ));
        }};

        private final Map<String, List<String>> womanCouncilorCandidates = new HashMap<>() {{
            put("Ward 1", List.of(
                    "Ms. Rahima Khatun - 5,200 votes",
                    "Ms. Fatima Khan - 4,800 votes",
                    "Ms. Anwara Begum - 4,500 votes"
            ));
            put("Ward 2", List.of(
                    "Ms. Mahmuda Akhter - 6,800 votes",
                    "Ms. Kamrun Nahar - 6,200 votes",
                    "Ms. Shahida Begum - 6,000 votes"
            ));
            put("Ward 3", List.of(
                    "Ms. Rokeya Begum - 7,200 votes",
                    "Ms. Naznin Akhter - 6,500 votes",
                    "Ms. Jahanara Begum - 6,300 votes"
            ));
        }};

        @FXML
        public void initialize() {
            // Load city corporations into ComboBox
            cityComboBox.setItems(FXCollections.observableArrayList(cityWardMap.keySet()));

            // Add toggle group to ensure only one toggle button can be selected
            mayorToggleButton.setOnAction(event -> showCandidateVotes("mayor"));
            councilorToggleButton.setOnAction(event -> showCandidateVotes("councilor"));
            womanCouncilorToggleButton.setOnAction(event -> showCandidateVotes("womanCouncilor"));
        }

        @FXML
        public void loadWards() {
            // Clear the Ward ComboBox
            wardComboBox.getItems().clear();

            // Load wards based on selected city
            String selectedCity = cityComboBox.getValue();
            if (selectedCity != null) {
                List<String> wards = cityWardMap.get(selectedCity);
                if (wards != null) {
                    wardComboBox.setItems(FXCollections.observableArrayList(wards));
                }
            }
        }

        private void showCandidateVotes(String position) {
            // Clear the ListView
            candidateListView.getItems().clear();

            // Get selected city or ward
            String selectedCity = cityComboBox.getValue();
            String selectedWard = wardComboBox.getValue();

            if (selectedCity == null || selectedWard == null) {
                candidateListView.getItems().add("Please select a city and ward first.");
                return;
            }

            // Show candidates based on the selected position
            List<String> candidates = switch (position) {
                case "mayor" -> mayorCandidates.getOrDefault(selectedCity, List.of("No candidates available."));
                case "councilor" -> councilorCandidates.getOrDefault(selectedWard, List.of("No candidates available."));
                case "womanCouncilor" -> womanCouncilorCandidates.getOrDefault(selectedWard, List.of("No candidates available."));
                default -> List.of("Invalid position selected.");
            };

            candidateListView.setItems(FXCollections.observableArrayList(candidates));
        }
    }


