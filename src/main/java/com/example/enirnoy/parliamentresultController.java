package com.example.enirnoy;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class parliamentresultController {
        @FXML
        private ComboBox<String> divisionComboBox;
        @FXML
        private ComboBox<String> districtComboBox;
        @FXML
        private VBox resultsContainer;

        // Mock data for divisions, districts, and results
        private final Map<String, List<String>> divisionDistrictMap = new HashMap<>();
        private final Map<String, List<String>> districtResultsMap = new HashMap<>();

        @FXML
        public void initialize() {
            // Populate mock data
            divisionDistrictMap.put("Rangpur", List.of("Panchagarh-1", "Panchagarh-2"));
            divisionDistrictMap.put("Mymensingh", List.of("Mymensingh-1", "Mymensingh-2"));

            districtResultsMap.put("Panchagarh-1", List.of("MOM: Md. Nazmul Islam Tuyya - Winner"));
            districtResultsMap.put("Panchagarh-2", List.of("MOM: Md. Nurul Islam Sujon - Winner"));

            // Set division data in the ComboBox
            divisionComboBox.setItems(FXCollections.observableArrayList(divisionDistrictMap.keySet()));

            // Add listener to update district ComboBox based on selected division
            divisionComboBox.setOnAction(event -> {
                String selectedDivision = divisionComboBox.getValue();
                districtComboBox.setItems(FXCollections.observableArrayList(divisionDistrictMap.getOrDefault(selectedDivision, List.of())));
                districtComboBox.getSelectionModel().clearSelection();
                resultsContainer.getChildren().clear(); // Clear previous results
            });

            // Add listener to display results based on selected district
            districtComboBox.setOnAction(event -> {
                String selectedDistrict = districtComboBox.getValue();
                resultsContainer.getChildren().clear();
                if (selectedDistrict != null && districtResultsMap.containsKey(selectedDistrict)) {
                    for (String result : districtResultsMap.get(selectedDistrict)) {
                        resultsContainer.getChildren().add(new Text(result));
                    }
                }
            });
        }
    }

