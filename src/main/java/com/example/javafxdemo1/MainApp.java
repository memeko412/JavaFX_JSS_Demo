package com.example.javafxdemo1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage stage;
    private AccountDashboardPage accountDashboardPage;
    private JobsAppliedPage jobsAppliedPage;
    private InterviewsPage interviewsPage;
    private ExploreJobsPage exploreJobsPage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;

        showLoginPage();
    }

    private void showLoginPage() {
        LoginApp loginApp = new LoginApp();
        loginApp.setLoginListener(this::onLoginSuccess);

        Scene scene = new Scene(loginApp.getContent(), 300, 200);
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();
    }

    private void onLoginSuccess() {
        accountDashboardPage = new AccountDashboardPage(this::onLogout);
        jobsAppliedPage = new JobsAppliedPage();
        interviewsPage = new InterviewsPage();
        exploreJobsPage = new ExploreJobsPage();

        BorderPane root = new BorderPane();
        root.setLeft(createSidebar());

        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Application");
        stage.show();

        showAccountDashboardPage();
    }

    private VBox createSidebar() {
        Button accountDashboardButton = createTabButton("Account Dashboard");
        accountDashboardButton.setOnAction(e -> showAccountDashboardPage());

        Button jobsAppliedButton = createTabButton("Jobs Applied");
        jobsAppliedButton.setOnAction(e -> showJobsAppliedPage());

        Button interviewsButton = createTabButton("Interviews");
        interviewsButton.setOnAction(e -> showInterviewsPage());

        Button exploreJobsButton = createTabButton("Explore Jobs");
        exploreJobsButton.setOnAction(e -> showExploreJobsPage());

        VBox sidebar = new VBox();
        sidebar.setPadding(new Insets(10));
        sidebar.setSpacing(10);
        sidebar.setAlignment(Pos.TOP_LEFT);
        sidebar.getChildren().addAll(accountDashboardButton, jobsAppliedButton, interviewsButton, exploreJobsButton);

        return sidebar;
    }

    private Button createTabButton(String text) {
        Button button = new Button(text);
        button.getStyleClass().add("tab-button");
        button.setPrefWidth(150);
        return button;
    }

    private void showAccountDashboardPage() {
        BorderPane root = (BorderPane) stage.getScene().getRoot();
        root.setCenter(accountDashboardPage);
        stage.setTitle("Account Dashboard");
    }

    private void showJobsAppliedPage() {
        BorderPane root = (BorderPane) stage.getScene().getRoot();
        root.setCenter(jobsAppliedPage);
        stage.setTitle("Jobs Applied");
    }

    private void showInterviewsPage() {
        BorderPane root = (BorderPane) stage.getScene().getRoot();
        root.setCenter(interviewsPage);
        stage.setTitle("Interviews");
    }

    private void showExploreJobsPage() {
        BorderPane root = (BorderPane) stage.getScene().getRoot();
        root.setCenter(exploreJobsPage);
        stage.setTitle("Explore Jobs");
    }

    private void onLogout() {
        showLoginPage();
    }
}
