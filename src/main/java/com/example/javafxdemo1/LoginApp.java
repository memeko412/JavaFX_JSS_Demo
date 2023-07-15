package com.example.javafxdemo1;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class LoginApp {

    private VBox content;
    private TextField usernameField;
    private PasswordField passwordField;
    private Button loginButton;

    public LoginApp() {
        initializeUI();
    }

    public void setLoginListener(Runnable loginListener) {
        loginButton.setOnAction(e -> loginListener.run());
    }

    public VBox getContent() {
        return content;
    }

    private void initializeUI() {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20));

        usernameField = new TextField();
        usernameField.setPromptText("Username");

        passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        loginButton = new Button("Login");

        Hyperlink forgotPasswordLink = new Hyperlink("Forgot Password");
        forgotPasswordLink.setOnAction(e -> handleForgotPasswordLinkClick());

        Hyperlink signUpLink = new Hyperlink("Sign Up");
        signUpLink.setOnAction(e -> handleSignUpLinkClick());

        gridPane.add(usernameField, 0, 0);
        gridPane.add(passwordField, 0, 1);
        gridPane.add(loginButton, 0, 2);
        gridPane.add(forgotPasswordLink, 0, 3);
        gridPane.add(signUpLink, 0, 4);

        content = new VBox(gridPane);
    }

    private void handleForgotPasswordLinkClick() {
        // Handle Forgot Password link click
    }

    private void handleSignUpLinkClick() {
        // Handle Sign Up link click
    }
}
