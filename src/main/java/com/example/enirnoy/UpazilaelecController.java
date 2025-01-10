package com.example.enirnoy;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UpazilaelecController {
        @FXML
        private ComboBox<String> divisionComboBox;

        @FXML
        private ComboBox<String> upazilaComboBox;

        @FXML
        private VBox candidateContainer;

        // Mock data for divisions and Upazilas
        private Map<String, List<String>> divisionUpazilaMap = new HashMap<>() {{
            put("Dhaka", List.of("Savar", "Dhamrai", "Keraniganj"));
            put("Chittagong", List.of("Rangunia", "Patiya", "Fatikchari"));
        }};

        @FXML
        public void initialize() {
            // Load divisions into the divisionComboBox
            divisionComboBox.setItems(FXCollections.observableArrayList(divisionUpazilaMap.keySet()));
        }

        @FXML
        public void loadUpazilas() {
            // Clear upazila comboBox and candidate container
            upazilaComboBox.getItems().clear();
            candidateContainer.getChildren().clear();

            // Get selected division and load its Upazilas
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
            // Clear previous candidates
            candidateContainer.getChildren().clear();

            // Example: Mock candidate data
            String[][] chairmanCandidates = {
                    {"Md. Asaduzzaman", "chairman_icon.png"},
                    {"Md. Golam Rahman", "chairman_icon2.png"}
            };

            // Display candidates
            displayCandidates(chairmanCandidates);
        }

        @FXML
        public void showViceChairmanCandidates() {
            // Clear previous candidates
            candidateContainer.getChildren().clear();

            // Example: Mock candidate data
            String[][] viceChairmanCandidates = {
                    {"Md. Rafiqul Islam", "vice_chairman_icon.png"},
                    {"Md. Sazzad Hossain", "vice_chairman_icon2.png"}
            };

            // Display candidates
            displayCandidates(viceChairmanCandidates);
        }

        @FXML
        public void showWomanViceChairmanCandidates() {
            // Clear previous candidates
            candidateContainer.getChildren().clear();

            // Example: Mock candidate data
            String[][] womanViceChairmanCandidates = {
                    {"Ms. Rahima Begum", "woman_vc_icon.png"},
                    {"Ms. Fatema Khatun", "woman_vc_icon2.png"}
            };

            // Display candidates
            displayCandidates(womanViceChairmanCandidates);
        }

        private void displayCandidates(String[][] candidates) {
            for (String[] candidate : candidates) {
                String name = candidate[0];
                String iconPath = candidate[1]; // Replace with actual path

                // Create a candidate item with icon and name
                HBox candidateItem = new HBox(10);
                ImageView icon = new ImageView(new Image(iconPath)); // Load image from resources
                icon.setFitWidth(50);
                icon.setFitHeight(50);
                Label nameLabel = new Label(name);

                candidateItem.getChildren().addAll(icon, nameLabel);
                candidateContainer.getChildren().add(candidateItem);
            }
        }
    }


