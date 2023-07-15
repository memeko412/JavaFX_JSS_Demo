package com.example.javafxdemo1;

import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;

public class SideTabPane extends VBox {
    private TabPane tabPane;

    public SideTabPane() {
        setSpacing(10);
        setPadding(new Insets(20));

        tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        tabPane.setSide(Side.LEFT);

        getChildren().add(tabPane);
    }

    public void addTab(String tabName, VBox content) {
        Tab tab = new Tab(tabName);
        tab.setContent(content);
        tabPane.getTabs().add(tab);
    }
}
