module com.example.javafxdemo1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.javafxdemo1 to javafx.fxml;
    exports com.example.javafxdemo1;
}