package com.example.enirnoy;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DashboardController {

        @FXML
        private Rectangle userReportBox;
        @FXML
        private Text userReportText;

        @FXML
        private Rectangle electionTemplateBox;
        @FXML
        private Text electionTemplateText;

        @FXML
        private Rectangle currentElectionBox;
        @FXML
        private Text currentElectionText;

        @FXML
        private Rectangle modifyVandCBox;
        @FXML
        private Text modifyVandCText;

        @FXML
        private Rectangle liveElectionListBox;
        @FXML
        private Text liveElectionListText;

        // Method to open a new scene
        private void openScene(String fxmlFile) {
            try {
                Stage stage = (Stage) userReportBox.getScene().getWindow(); // Get current window (stage)
                FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile)); // Load the corresponding scene
                Scene scene = new Scene(loader.load(), 800, 600); // Set new scene size (adjust as necessary)
                stage.setScene(scene); // Set the scene on the stage
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        // Handle clicks for each rectangle
        @FXML
        private void handleUserReportClick(MouseEvent event) {
            openScene("UserReportbox.fxml");
        }

        @FXML
        private void handleElectionTemplateClick(MouseEvent event) {
            openScene("ListofElection.fxml");
        }

        @FXML
        private void handleCurrentElectionClick(MouseEvent event) {
            openScene("CurrentElection.fxml");
        }

        @FXML
        private void handleModifyVandCClick(MouseEvent event) {
            openScene("ModifyV&CAccount.fxml");
        }

        @FXML
        private void handleLiveElectionListClick(MouseEvent event) {
            openScene("LiveElectionList.fxml");
        }

        // Optionally, add mouse event listeners for rectangles if you want them to be clickable
        @FXML
        public void initialize() {
            // Add listeners to rectangles to trigger respective actions when clicked
            userReportBox.setOnMouseClicked(this::handleUserReportClick);
            electionTemplateBox.setOnMouseClicked(this::handleElectionTemplateClick);
            currentElectionBox.setOnMouseClicked(this::handleCurrentElectionClick);
            modifyVandCBox.setOnMouseClicked(this::handleModifyVandCClick);
            liveElectionListBox.setOnMouseClicked(this::handleLiveElectionListClick);

            // Optionally add mouse event listeners for the text if you want the text to be clickable
            userReportText.setOnMouseClicked(this::handleUserReportClick);
            electionTemplateText.setOnMouseClicked(this::handleElectionTemplateClick);
            currentElectionText.setOnMouseClicked(this::handleCurrentElectionClick);
            modifyVandCText.setOnMouseClicked(this::handleModifyVandCClick);
            liveElectionListText.setOnMouseClicked(this::handleLiveElectionListClick);
        }
    }

