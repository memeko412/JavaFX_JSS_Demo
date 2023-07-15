package com.example.javafxdemo1;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class AccountDashboardPage extends GridPane {

    public AccountDashboardPage(Runnable logoutListener) {
        initializeUI(logoutListener);
    }

    private void initializeUI(Runnable logoutListener) {
        setPadding(new Insets(20));
        setHgap(10);
        setVgap(10);


        Button logoutButton = new Button("Logout");
        logoutButton.setOnAction(e -> logoutListener.run());

        Image profileImage = new Image("placeholder.jpg");
        ImageView imageView = new ImageView(profileImage);
        imageView.setFitWidth(100);
        imageView.setPreserveRatio(true);

        Label nameLabel = new Label("Amamiya Kokoro");
        nameLabel.setFont(new Font(18));

        Label bioLabel = new Label("Software Developer");
        bioLabel.setFont(new Font(14));

        Label locationLabel = new Label("Melbourne, Victoria, Australia");
        locationLabel.setFont(new Font(14));

        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(imageView, nameLabel, bioLabel, locationLabel);
        add(vbox, 0, 0);
        vbox.getChildren().addAll(logoutButton);
    }
}
