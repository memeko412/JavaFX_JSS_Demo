package com.example.javafxdemo1;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InterviewsPage extends VBox {

    private ListView<String> interviewsListView;

    public InterviewsPage() {
        initializeUI();
    }

    private void initializeUI() {
        interviewsListView = new ListView<>();
        interviewsListView.setPrefHeight(200);

        List<String> interviews = getMockInterviews();

        for (String interview : interviews) {
            interviewsListView.getItems().add(interview);
        }

        ScrollPane scrollPane = new ScrollPane(interviewsListView);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setPadding(new Insets(20));

        getChildren().add(scrollPane);
    }

    private List<String> getMockInterviews() {
        List<String> interviews = new ArrayList<>();

        // Mock interview data
        interviews.add("Interview Company X, " + LocalDate.now().plusDays(1) + ", Scheduled");
        interviews.add("Interview Company Y, " + LocalDate.now().plusDays(3) + ", Pending");
        interviews.add("Interview Company Z, " + LocalDate.now().plusDays(5) + ", Rejected");
        // Add more mock data as needed

        return interviews;
    }
}
