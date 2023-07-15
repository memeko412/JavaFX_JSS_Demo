package com.example.javafxdemo1;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class JobsAppliedPage extends VBox {

    private ListView<String> jobsListView;

    public JobsAppliedPage() {
        initializeUI();
    }

    private void initializeUI() {
        jobsListView = new ListView<>();
        jobsListView.setPrefHeight(200);

        List<String> jobApplications = getMockJobApplications();

        // Sort the job applications by the latest job first
        jobApplications.sort(Comparator.reverseOrder());

        for (String jobApplication : jobApplications) {
            jobsListView.getItems().add(jobApplication);
        }

        ScrollPane scrollPane = new ScrollPane(jobsListView);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setPadding(new Insets(20));

        getChildren().add(scrollPane);
    }

    private List<String> getMockJobApplications() {
        List<String> jobApplications = new ArrayList<>();

        // Mock job application data
        jobApplications.add("Job A, " + LocalDate.now().minusDays(2) + ", Approved");
        jobApplications.add("Job B, " + LocalDate.now().minusDays(5) + ", Rejected");
        jobApplications.add("Job C, " + LocalDate.now().minusDays(7) + ", Pending");
        // Add more mock data as needed

        return jobApplications;
    }
}
