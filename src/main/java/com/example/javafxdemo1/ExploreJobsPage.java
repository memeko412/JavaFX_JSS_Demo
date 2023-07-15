package com.example.javafxdemo1;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExploreJobsPage extends VBox {

    private ListView<String> jobListingsListView;
    private TextField searchTextField;
    private Button filterButton;
    private Button searchButton;

    public ExploreJobsPage() {
        initializeUI();
    }

    private void initializeUI() {
        HBox searchBox = createSearchBox();

        jobListingsListView = new ListView<>();
        jobListingsListView.setPrefHeight(200);

        List<String> jobListings = getMockJobListings();

        for (String jobListing : jobListings) {
            jobListingsListView.getItems().add(jobListing);
        }

        jobListingsListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                showJobListingDetails(newValue);
                jobListingsListView.getSelectionModel().clearSelection();
            }
        });

        getChildren().addAll(searchBox, jobListingsListView);
    }

    private HBox createSearchBox() {
        searchTextField = new TextField();
        searchTextField.setPrefWidth(200);

        filterButton = new Button("Filter");
        filterButton.setOnAction(e -> handleFilterButtonClick());

        searchButton = new Button("Search");
        searchButton.setOnAction(e -> handleSearchButtonClick());

        HBox searchBox = new HBox(10);
        searchBox.setPadding(new Insets(10));
        searchBox.getChildren().addAll(searchTextField, filterButton, searchButton);

        return searchBox;
    }

    private void handleFilterButtonClick() {
        // Handle filter button click
    }

    private void handleSearchButtonClick() {
        // Handle search button click
    }

    private List<String> getMockJobListings() {
        List<String> jobListings = new ArrayList<>();

        // Mock job listing data
        jobListings.add("Job A, Company X, Full-time, " + LocalDate.now().plusDays(10));
        jobListings.add("Job B, Company Y, Part-time, " + LocalDate.now().plusDays(15));
        jobListings.add("Job C, Company Z, Contract, " + LocalDate.now().plusDays(20));
        jobListings.add("Job D, Company A, Full-time, " + LocalDate.now().plusDays(8));
        jobListings.add("Job E, Company B, Part-time, " + LocalDate.now().plusDays(13));
        jobListings.add("Job F, Company C, Full-time, " + LocalDate.now().plusDays(17));
        jobListings.add("Job G, Company D, Contract, " + LocalDate.now().plusDays(22));
        jobListings.add("Job H, Company E, Part-time, " + LocalDate.now().plusDays(9));
        jobListings.add("Job I, Company F, Full-time, " + LocalDate.now().plusDays(12));
        jobListings.add("Job J, Company G, Contract, " + LocalDate.now().plusDays(18));
        jobListings.add("Job K, Company H, Part-time, " + LocalDate.now().plusDays(21));
        jobListings.add("Job L, Company I, Full-time, " + LocalDate.now().plusDays(7));
        jobListings.add("Job M, Company J, Contract, " + LocalDate.now().plusDays(11));
        jobListings.add("Job N, Company K, Part-time, " + LocalDate.now().plusDays(16));
        jobListings.add("Job O, Company L, Full-time, " + LocalDate.now().plusDays(19));
        jobListings.add("Job P, Company M, Contract, " + LocalDate.now().plusDays(6));
        jobListings.add("Job Q, Company N, Part-time, " + LocalDate.now().plusDays(14));
        jobListings.add("Job R, Company O, Full-time, " + LocalDate.now().plusDays(23));
        jobListings.add("Job S, Company P, Contract, " + LocalDate.now().plusDays(5));
        jobListings.add("Job T, Company Q, Part-time, " + LocalDate.now().plusDays(24));

        return jobListings;
    }

    private void showJobListingDetails(String jobListing) {
        String[] jobDetails = jobListing.split(", ");

        if (jobDetails.length >= 4) {
            String jobName = jobDetails[0].trim();
            String companyName = jobDetails[1].trim();
            String jobType = jobDetails[2].trim();
            String listingEndDate = jobDetails[3].trim();

            JobListingWindow jobListingWindow = new JobListingWindow(jobName, companyName, jobType, listingEndDate);
            jobListingWindow.show();
        } else {
            showAlert("Invalid job listing format");
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
