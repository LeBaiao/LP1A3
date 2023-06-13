module com.example.animaisprojectfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.animaisprojectfx to javafx.fxml;
    exports com.example.animaisprojectfx;
}