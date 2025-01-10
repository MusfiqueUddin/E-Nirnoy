package com.example.enirnoy;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LiveparliamentresultController {
        @FXML
        private ComboBox<String> divisionComboBox;

        @FXML
        private ComboBox<String> districtComboBox;

        @FXML
        private ListView<String> candidateListView;

        private final Map<String, List<String>> divisionDistrictMap = new HashMap<>();
        private final Map<String, List<String>> candidateMap = new HashMap<>();

        @FXML
        public void initialize() {
            // Populate division and district data
            divisionDistrictMap.put("Rangpur", List.of("Panchagarh", "Thakurgaon", "Dinajpur", "Nilphamari", "Lalmonirhat", "Kurigram", "Gaibandha", "Rangpur"));
            divisionDistrictMap.put("Rajshahi", List.of("Joypurhat", "Bogra", "Chapai Nawabganj", "Naogaon", "Rajshahi", "Natore", "Sirajganj", "Pabna"));
            divisionDistrictMap.put("Khulna", List.of("Meherpur", "Kushtia", "Chuadanga", "Jhenaidah", "Jessore", "Magura", "Narail", "Bagerhat", "Khulna", "Satkhira"));
            divisionDistrictMap.put("Barisal", List.of("Barguna", "Patuakhali", "Bhola", "Barisal", "Jhalokati", "Pirojpur"));
            divisionDistrictMap.put("Mymensingh", List.of("Jamalpur", "Sherpur", "Mymensingh", "Netrokona"));
            divisionDistrictMap.put("Dhaka", List.of("Tangail", "Kishoreganj", "Manikganj", "Munshiganj", "Dhaka", "Gazipur", "Narsingdi", "Narayanganj", "Rajbari", "Faridpur", "Gopalganj", "Madaripur", "Shariatpur"));
            divisionDistrictMap.put("Sylhet", List.of("Sunamganj", "Sylhet", "Moulvibazar", "Habiganj"));
            divisionDistrictMap.put("Chittagong", List.of("Brahmanbaria", "Comilla", "Chandpur", "Feni", "Noakhali", "Lakshmipur", "Chittagong", "Cox's Bazar", "Khagrachhari", "Rangamati", "Bandarban"));

            // Populate candidate data (example for simplicity)
            candidateMap.put("Rangpur-Panchagarh", List.of("Candidate 1 - Votes: 15000", "Candidate 2 - Votes: 12000", "Candidate 3 - Votes: 18000"));
            candidateMap.put("Dhaka-Tangail", List.of("Candidate A - Votes: 25000", "Candidate B - Votes: 22000"));

            divisionComboBox.setItems(FXCollections.observableArrayList(divisionDistrictMap.keySet()));

            divisionComboBox.setOnAction(event -> onDivisionSelected());
            districtComboBox.setOnAction(event -> onDistrictSelected());
        }

        private void onDivisionSelected() {
            String selectedDivision = divisionComboBox.getValue();
            if (selectedDivision != null) {
                List<String> districts = divisionDistrictMap.get(selectedDivision);
                if (districts != null) {
                    districtComboBox.setItems(FXCollections.observableArrayList(districts));
                    districtComboBox.setValue(null);
                    candidateListView.getItems().clear();
                }
            }
        }

        private void onDistrictSelected() {
            String selectedDivision = divisionComboBox.getValue();
            String selectedDistrict = districtComboBox.getValue();

            if (selectedDivision != null && selectedDistrict != null) {
                String key = selectedDivision + "-" + selectedDistrict;
                List<String> candidates = candidateMap.get(key);
                if (candidates != null) {
                    candidateListView.setItems(FXCollections.observableArrayList(candidates));
                } else {
                    candidateListView.getItems().clear();
                }
            }
        }
    }


