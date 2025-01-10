package com.example.enirnoy;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class LiveElectionListController {


        // FXML elements
        @FXML
        private Rectangle liveResultRectangle;

        @FXML
        private Rectangle publishResultRectangle;

        // Initialize method to set up mouse event handlers
        @FXML
        public void initialize() {
            // Set up the click event for Live Result Rectangle
            liveResultRectangle.setOnMouseClicked(this::openLiveResultScene);

            // Set up the click event for Publish Result Rectangle
            publishResultRectangle.setOnMouseClicked(this::openPublishResultScene);
        }

        // Method to open the Live Result Scene
        private void openLiveResultScene(MouseEvent event) {
            try {
                // Load the Live Result scene (FXML file)
                Parent liveResultSceneRoot = FXMLLoader.load(getClass().getResource("LiveResult.fxml"));
                Scene liveResultScene = new Scene(liveResultSceneRoot);

                // Get the current stage and set the new scene
                Stage stage = (Stage) liveResultRectangle.getScene().getWindow();
                stage.setScene(liveResultScene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Method to open the Publish Result Scene
        private void openPublishResultScene(MouseEvent event) {
            try {
                // Load the Publish Result scene (FXML file)
                Parent publishResultSceneRoot = FXMLLoader.load(getClass().getResource("PublishResult.fxml"));
                Scene publishResultScene = new Scene(publishResultSceneRoot);

                // Get the current stage and set the new scene
                Stage stage = (Stage) publishResultRectangle.getScene().getWindow();
                stage.setScene(publishResultScene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

