package com.example.enirnoy;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UpazilaresultController {
        @FXML
        private ComboBox<String> divisionComboBox;

        @FXML
        private ComboBox<String> upazilaComboBox;

        @FXML
        private ListView<String> candidateListView;

        // Division and Upazila Data
        private final Map<String, List<String>> divisionUpazilaMap = new HashMap<>() {{
            put("Dhaka", List.of("Savar", "Dhamrai", "Keraniganj"));
            put("Chittagong", List.of("Rangunia", "Patiya", "Fatikchari"));
            put("Sylhet", List.of("Beanibazar", "Jaintiapur", "Gowainghat"));
        }};

        // Candidates with votes for each position
        private final Map<String, List<String>> chairmanCandidates = new HashMap<>() {{
            put("Savar", List.of(
                    "Md. Asaduzzaman - 15,000 votes",
                    "Md. Rahim Ullah - 12,000 votes",
                    "Md. Karim Khan - 10,000 votes"
            ));
            put("Rangunia", List.of(
                    "Md. Abdullah Al Mamun - 14,500 votes",
                    "Md. Nasir Uddin - 13,000 votes",
                    "Md. Sajid Khan - 11,500 votes"
            ));
            put("Beanibazar", List.of(
                    "Md. Karim Ullah - 16,200 votes",
                    "Md. Aziz Khan - 13,400 votes",
                    "Md. Jalal Uddin - 12,900 votes"
            ));
        }};

        private final Map<String, List<String>> viceChairmanCandidates = new HashMap<>() {{
            put("Savar", List.of(
                    "Md. Rafiqul Islam - 14,000 votes",
                    "Md. Kamal Khan - 12,500 votes",
                    "Md. Hasib Rahman - 11,200 votes"
            ));
            put("Rangunia", List.of(
                    "Md. Nazrul Islam - 15,300 votes",
                    "Md. Hamid Khan - 13,700 votes",
                    "Md. Mizanur Rahman - 12,400 votes"
            ));
            put("Beanibazar", List.of(
                    "Md. Anisur Rahman - 17,000 votes",
                    "Md. Wahid Khan - 14,200 votes",
                    "Md. Bashir Ullah - 13,800 votes"
            ));
        }};

        private final Map<String, List<String>> womanViceChairmanCandidates = new HashMap<>() {{
            put("Savar", List.of(
                    "Ms. Rahima Khatun - 12,000 votes",
                    "Ms. Fatima Khan - 10,500 votes",
                    "Ms. Anwara Begum - 9,800 votes"
            ));
            put("Rangunia", List.of(
                    "Ms. Rokeya Begum - 14,200 votes",
                    "Ms. Naznin Akhter - 13,400 votes",
                    "Ms. Jahanara Begum - 12,900 votes"
            ));
            put("Beanibazar", List.of(
                    "Ms. Mahmuda Akhter - 15,000 votes",
                    "Ms. Kamrun Nahar - 13,800 votes",
                    "Ms. Shahida Begum - 12,700 votes"
            ));
        }};

        @FXML
        public void initialize() {
            // Load divisions into the ComboBox
            divisionComboBox.setItems(FXCollections.observableArrayList(divisionUpazilaMap.keySet()));
        }

        @FXML
        public void loadUpazilas() {
            // Clear Upazila ComboBox
            upazilaComboBox.getItems().clear();

            // Load Upazilas based on selected division
            String selectedDivision = divisionComboBox.getValue();
            if (selectedDivision != null) {
                List<String> upazilas = divisionUpazilaMap.get(selectedDivision);
                if (upazilas != null) {
                    upazilaComboBox.setItems(FXCollections.observableArrayList(upazilas));
                }
            }
        }

        @FXML
        public void showChairmanCandidates() {
            displayCandidates(chairmanCandidates);
        }

        @FXML
        public void showViceChairmanCandidates() {
            displayCandidates(viceChairmanCandidates);
        }

        @FXML
        public void showWomanViceChairmanCandidates() {
            displayCandidates(womanViceChairmanCandidates);
        }

        private void displayCandidates(Map<String, List<String>> candidateMap) {
            // Clear the ListView
            candidateListView.getItems().clear();

            // Get selected Upazila
            String selectedUpazila = upazilaComboBox.getValue();
            if (selectedUpazila != null && candidateMap.containsKey(selectedUpazila)) {
                List<String> candidates = candidateMap.get(selectedUpazila);
                candidateListView.setItems(FXCollections.observableArrayList(candidates));
            } else {
                candidateListView.setItems(FXCollections.observableArrayList("No candidate data available for the selected Upazila."));
            }
        }
    }


