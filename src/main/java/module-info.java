module com.example.enirnoy {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.enirnoy to javafx.fxml;
    exports com.example.enirnoy;
}