package com.example.enirnoy;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class LiveResultController {

        @FXML private ComboBox<String> electionComboBox;
        @FXML private ComboBox<String> divisionComboBox;
        @FXML private ComboBox<String> districtComboBox;
        @FXML private ComboBox<String> pourosovaComboBox;

        @FXML private Button mayorButton;
        @FXML private Button councillorButton;
        @FXML private Button womanCouncillorButton;
        @FXML private Button chairmanButton;
        @FXML private Button viceChairmanButton;
        @FXML private Button womanViceChairmanButton;

        @FXML private TableView<Result> resultsTableView;
        @FXML private TableColumn<Result, String> positionColumn;
        @FXML private TableColumn<Result, String> candidateColumn;
        @FXML private TableColumn<Result, String> voteCountColumn;

        private ObservableList<Result> results = FXCollections.observableArrayList();

        @FXML
        public void initialize() {
            // Initialize ComboBoxes
            electionComboBox.setItems(FXCollections.observableArrayList("City Corporation", "Upazila Parishod", "Municipality", "National Parliament"));
            divisionComboBox.setItems(FXCollections.observableArrayList("Barishal", "Chattogram","Dhaka","Kulna","Mymensingh","Rajshahi","Rangpur","Sylhet"));
            districtComboBox.setItems(FXCollections.observableArrayList("District 1", "District 2"));
            pourosovaComboBox.setItems(FXCollections.observableArrayList("Pourosova 1", "Pourosova 2"));

            // Initialize TableView columns
            positionColumn.setCellValueFactory(cellData -> cellData.getValue().positionProperty());
            candidateColumn.setCellValueFactory(cellData -> cellData.getValue().candidateProperty());
            voteCountColumn.setCellValueFactory(cellData -> cellData.getValue().votesProperty());

            // Set the TableView items
            resultsTableView.setItems(results);

            // Initially set Pourosova ComboBox to be hidden
            pourosovaComboBox.setVisible(false);
        }

        @FXML
        private void handleElectionSelection(ActionEvent event) {
            String selectedElection = electionComboBox.getSelectionModel().getSelectedItem();

            // Show/hide buttons and ComboBoxes based on selected election type
            if ("City Corporation".equals(selectedElection)) {
                mayorButton.setVisible(true);
                councillorButton.setVisible(true);
                womanCouncillorButton.setVisible(true);
                chairmanButton.setVisible(false);
                viceChairmanButton.setVisible(false);
                womanViceChairmanButton.setVisible(false);
                pourosovaComboBox.setVisible(false); // Hide Pourosova
            } else if ("Upazila Parishod".equals(selectedElection)) {
                chairmanButton.setVisible(true);
                viceChairmanButton.setVisible(true);
                womanViceChairmanButton.setVisible(true);
                mayorButton.setVisible(false);
                councillorButton.setVisible(false);
                womanCouncillorButton.setVisible(false);
                pourosovaComboBox.setVisible(false); // Hide Pourosova
            } else if ("Municipality".equals(selectedElection)) {
                mayorButton.setVisible(true);
                councillorButton.setVisible(true);
                womanCouncillorButton.setVisible(true);
                chairmanButton.setVisible(false);
                viceChairmanButton.setVisible(false);
                womanViceChairmanButton.setVisible(false);
                pourosovaComboBox.setVisible(true); // Show Pourosova for Municipality
            } else if ("National Parliament".equals(selectedElection)) {
                openNationalParliamentScene(); // Open new scene for National Parliament
            } else {
                mayorButton.setVisible(false);
                councillorButton.setVisible(false);
                womanCouncillorButton.setVisible(false);
                chairmanButton.setVisible(false);
                viceChairmanButton.setVisible(false);
                womanViceChairmanButton.setVisible(false);
                pourosovaComboBox.setVisible(false); // Hide all elements for other elections
            }
        }

        @FXML
        private void handlePositionSelection(MouseEvent event) {
            String position = ((Button) event.getSource()).getText();  // Get the text of the clicked button
            updateCandidates(position);
        }

        private void updateCandidates(String position) {
            results.clear();  // Clear previous results

            // Add sample data for candidates based on selected position
            if ("Mayor".equals(position)) {
                results.add(new Result("Mayor", "John Doe", "1200"));
                results.add(new Result("Mayor", "Jane Smith", "1100"));
            } else if ("Councillor".equals(position)) {
                results.add(new Result("Councillor", "Mike Brown", "900"));
                results.add(new Result("Councillor", "Sara White", "850"));
            } else if ("Woman Councillor".equals(position)) {
                results.add(new Result("Woman Councillor", "Emily Johnson", "950"));
                results.add(new Result("Woman Councillor", "Sophia Lee", "880"));
            } else if ("Chairman".equals(position)) {
                results.add(new Result("Chairman", "Mr. Chairman", "1500"));
                results.add(new Result("Chairman", "Mrs. Chairwoman", "1400"));
            } else if ("Vice Chairman".equals(position)) {
                results.add(new Result("Vice Chairman", "Mr. Vice Chairman", "1300"));
                results.add(new Result("Vice Chairman", "Mrs. Vice Chairwoman", "1250"));
            } else if ("Woman Vice Chairman".equals(position)) {
                results.add(new Result("Woman Vice Chairman", "Ms. Woman Vice Chairman", "1100"));
                results.add(new Result("Woman Vice Chairman", "Mrs. Woman Vice Chairwoman", "1000"));
            }
        }

        private void openNationalParliamentScene() {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("NationalParliamentScene.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }




