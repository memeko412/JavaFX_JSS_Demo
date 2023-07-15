package com.example.javafxdemo1;

import javafx.scene.layout.VBox;

public interface Page {
    VBox createContent();
    void show();
}
