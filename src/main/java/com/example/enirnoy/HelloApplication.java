package com.example.enirnoy;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
        public void start(Stage primaryStage) {
            try {
                // Load the Dashboard.fxml file
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
                AnchorPane root = loader.load();

                // Create a scene with the loaded layout and set it on the stage
                Scene scene = new Scene(root, 800, 600); // You can adjust the size as needed
                primaryStage.setScene(scene);

                // Set the stage title and show it
                primaryStage.setTitle("Dashboard");
                primaryStage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }}