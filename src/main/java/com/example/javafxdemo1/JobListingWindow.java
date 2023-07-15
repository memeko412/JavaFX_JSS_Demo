package com.example.javafxdemo1;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JobListingWindow extends Stage {

    public JobListingWindow(String jobName, String companyName, String jobType, String listingEndDate) {
        initializeUI(jobName, companyName, jobType, listingEndDate);
    }

    private void initializeUI(String jobName, String companyName, String jobType, String listingEndDate) {
        setTitle("Job Details");

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20));

        Label nameLabel = new Label("Job Name:");
        Label companyNameLabel = new Label("Company Name:");
        Label jobTypeLabel = new Label("Job Type:");
        Label listingEndDateLabel = new Label("Listing End Date:");

        Label nameValueLabel = new Label(jobName);
        Label companyNameValueLabel = new Label(companyName);
        Label jobTypeValueLabel = new Label(jobType);
        Label listingEndDateValueLabel = new Label(listingEndDate);

        Button applyButton = new Button("Apply for Job");
        Button watchListButton = new Button("Add to Watch List");

        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(applyButton, watchListButton);

        gridPane.add(nameLabel, 0, 0);
        gridPane.add(nameValueLabel, 1, 0);
        gridPane.add(companyNameLabel, 0, 1);
        gridPane.add(companyNameValueLabel, 1, 1);
        gridPane.add(jobTypeLabel, 0, 2);
        gridPane.add(jobTypeValueLabel, 1, 2);
        gridPane.add(listingEndDateLabel, 0, 3);
        gridPane.add(listingEndDateValueLabel, 1, 3);
        gridPane.add(buttonBox, 0, 4, 2, 1);

        VBox vbox = new VBox(gridPane);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));

        Scene scene = new Scene(vbox);
        setScene(scene);
    }
}
